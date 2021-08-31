package com.realbizgames.demo.mongo.repository;

import com.realbizgames.demo.mongo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, String> {

}
