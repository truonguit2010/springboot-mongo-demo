package com.realbizgames.demo.mongo.convertor;

import com.realbizgames.demo.mongo.dto.UserDTO;
import com.realbizgames.demo.mongo.entity.UserEntity;
import com.realbizgames.demo.mongo.utils.DateTimeConvertor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDTOConvertor implements IConvertor<UserEntity, UserDTO> {

    @Override
    public UserDTO convert(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setBirthday(DateTimeConvertor.from(entity.getBirthday()));

        dto.setCreatedAt(DateTimeConvertor.from(entity.getCreatedAt()));
        dto.setUpdatedAt(DateTimeConvertor.from(entity.getUpdatedAt()));
        return dto;
    }

    @Override
    public List<UserDTO> convert(Iterable<UserEntity> entities) {
        List<UserDTO> dtoList = new ArrayList<>();
        for (var entity : entities) {
            dtoList.add(convert(entity));
        }
        return dtoList;
    }
}
