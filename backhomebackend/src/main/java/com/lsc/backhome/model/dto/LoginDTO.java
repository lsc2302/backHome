package com.lsc.backhome.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginDTO {
    @NotBlank(message = "empty username not allowed")
    @Size(min = 2, max = 15, message = "username length between 2-15")
    private String username;

    @NotBlank(message = "empty password not allowed")
    @Size(min = 6, max = 20, message = "password length between6-20")
    private String password;

}
