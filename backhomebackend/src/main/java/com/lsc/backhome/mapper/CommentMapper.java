package com.lsc.backhome.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsc.backhome.model.entity.Comment;
import com.lsc.backhome.model.vo.CommentVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    List<CommentVO> getCommentsBySiteID(@Param("siteid") int siteid);
}
