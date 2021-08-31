package com.realbizgames.demo.mongo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String birthday;

    @NotBlank(message = "Email is mandatory")
    private String email;

    private String createdAt;
    private String updatedAt;
}
