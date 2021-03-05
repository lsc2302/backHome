package com.lsc.backhome.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 4852567257599682616L;

    private Integer site_id;

    private String content;

    private Integer stars;

}
