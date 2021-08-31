package com.realbizgames.demo.mongo.service;

import com.realbizgames.demo.mongo.consts.ServiceErrorCode;
import com.realbizgames.demo.mongo.convertor.UserDTOConvertor;
import com.realbizgames.demo.mongo.convertor.UserEntityConvertor;
import com.realbizgames.demo.mongo.dto.UserDTO;
import com.realbizgames.demo.mongo.entity.UserEntity;
import com.realbizgames.demo.mongo.exception.BaseServiceException;
import com.realbizgames.demo.mongo.repository.UserEntityRepository;
import com.realbizgames.demo.mongo.utils.DateTimeConvertor;
import com.realbizgames.demo.mongo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private UserEntityConvertor userEntityConvertor;
    @Autowired
    private UserDTOConvertor userDTOConvertor;
    @Autowired
    private MessageSource messageSource;

    @Override
    public UserDTO create(UserDTO dto) {
        UserEntity entity = userEntityConvertor.convert(dto);
        UserEntity createdOne = userEntityRepository.save(entity);
        return userDTOConvertor.convert(createdOne);
    }

    @Override
    public void update(UserDTO dto) {
        if (StringUtils.isNullOrEmpty(dto.getId())) {
            throw BaseServiceException.of(ServiceErrorCode.USER_ID_NULL_OR_EMPTY_EXCEPTION, messageSource, "user.exception.id-null-or-empty");
        }
        Optional<UserEntity> optional = userEntityRepository.findById(dto.getId());
        if (optional.isEmpty()) {
            throw BaseServiceException.of(ServiceErrorCode.USER_NOT_FOUND_EXCEPTION, messageSource, "user.exception.not-found-by-id", new Object[]{dto.getId()});
        }
        UserEntity oldOne = optional.get();

        UserEntity newOne = userEntityConvertor.convert(dto);
        newOne.setCreatedAt(oldOne.getCreatedAt());
        userEntityRepository.save(newOne);
    }

    @Override
    public void patch(UserDTO dto) {
        if (StringUtils.isNullOrEmpty(dto.getId())) {
            throw BaseServiceException.of(ServiceErrorCode.USER_ID_NULL_OR_EMPTY_EXCEPTION, messageSource, "user.exception.id-null-or-empty");
        }
        Optional<UserEntity> optional = userEntityRepository.findById(dto.getId());
        if (optional.isEmpty()) {
            throw BaseServiceException.of(ServiceErrorCode.USER_NOT_FOUND_EXCEPTION, messageSource, "user.exception.not-found-by-id", new Object[]{dto.getId()});
        }
        UserEntity oldOne = optional.get();
        if (dto.getFirstName() != null) {
            oldOne.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            oldOne.setLastName(dto.getLastName());
        }
        if (dto.getBirthday() != null) {
            oldOne.setBirthday(DateTimeConvertor.to(dto.getBirthday()));
        }
        userEntityRepository.save(oldOne);
    }

    @Override
    public UserDTO get(String id) {
        if (StringUtils.isNullOrEmpty(id)) {
            throw BaseServiceException.of(ServiceErrorCode.USER_ID_NULL_OR_EMPTY_EXCEPTION, messageSource, "user.exception.id-null-or-empty");
        }
        Optional<UserEntity> optional = userEntityRepository.findById(id);
        if (optional.isEmpty()) {
            throw BaseServiceException.of(ServiceErrorCode.USER_NOT_FOUND_EXCEPTION, messageSource, "user.exception.not-found-by-id", new Object[]{id});
        }
        return userDTOConvertor.convert(optional.get());
    }

    @Override
    public void delete(String id) {
        if (StringUtils.isNullOrEmpty(id)) {
            throw BaseServiceException.of(ServiceErrorCode.USER_ID_NULL_OR_EMPTY_EXCEPTION, messageSource, "user.exception.id-null-or-empty");
        }
        Optional<UserEntity> optional = userEntityRepository.findById(id);
        if (optional.isEmpty()) {
            throw BaseServiceException.of(ServiceErrorCode.USER_NOT_FOUND_EXCEPTION, messageSource, "user.exception.not-found-by-id", new Object[]{id});
        }
        userEntityRepository.deleteById(id);
    }
}
