package com.lsc.backhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsc.backhome.mapper.CommentMapper;
import com.lsc.backhome.model.dto.CommentDTO;
import com.lsc.backhome.model.entity.Comment;
import com.lsc.backhome.model.entity.RegisteredUser;
import com.lsc.backhome.model.vo.CommentVO;
import com.lsc.backhome.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Override
    public List<CommentVO> getCommentsBySiteID(int siteID){
        List<CommentVO> comments = new ArrayList();
        try {
            comments = this.baseMapper.getCommentsBySiteID(siteID);
        } catch (Exception e) {
            log.info("lstBmsComment失败");
        }
        return comments;
    }

    @Override
    public Comment create(CommentDTO commentdto, RegisteredUser user){
        Comment comment = Comment.builder()
                .userId(user.getId())
                .content(commentdto.getContent())
                .siteId(commentdto.getSite_id())
                .createTime(new Date())
                .build();
        this.baseMapper.insert(comment);
        return comment;
    }
}
