package com.lsc.backhome.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsc.backhome.model.dto.CommentDTO;
import com.lsc.backhome.model.entity.Comment;
import com.lsc.backhome.model.entity.RegisteredUser;
import com.lsc.backhome.model.vo.CommentVO;

import java.util.List;

public interface CommentService extends IService<Comment> {
    List<CommentVO> getCommentsBySiteID(int siteID);
    Comment create(CommentDTO dto, RegisteredUser principal);
}
