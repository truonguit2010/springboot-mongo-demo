package com.realbizgames.demo.mongo.service;

import com.realbizgames.demo.mongo.dto.UserDTO;

public interface IUserService {

    UserDTO create(UserDTO dto);

    void update(UserDTO dto);

    void patch(UserDTO dto);

    UserDTO get(String id);

    void delete(String id);
}
