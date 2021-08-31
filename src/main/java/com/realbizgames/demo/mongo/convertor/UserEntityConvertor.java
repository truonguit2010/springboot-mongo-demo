package com.realbizgames.demo.mongo.convertor;

import com.realbizgames.demo.mongo.dto.UserDTO;
import com.realbizgames.demo.mongo.entity.UserEntity;
import com.realbizgames.demo.mongo.utils.DateTimeConvertor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserEntityConvertor implements IConvertor<UserDTO, UserEntity> {

    @Override
    public UserEntity convert(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirthday(DateTimeConvertor.to(dto.getBirthday()));

        return entity;
    }

    @Override
    public List<UserEntity> convert(Iterable<UserDTO> dtoList) {
        List<UserEntity> entities = new ArrayList<>();
        for (var dto : dtoList) {
            entities.add(convert(dto));
        }
        return entities;
    }
}
