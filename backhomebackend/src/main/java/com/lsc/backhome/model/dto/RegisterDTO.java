package com.lsc.backhome.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;


@Data
public class RegisterDTO {
    @NotEmpty(message = "Please input name")
    @Length(min = 2, max = 15, message = "length 2-15")
    private String name;

    @NotEmpty(message = "Please input password")
    @Length(min = 6, max = 20, message = "length 6-20")
    private String pass;

}
