package com.lsc.backhome.controller;

import com.lsc.backhome.common.api.ApiResult;
import com.lsc.backhome.model.dto.CommentDTO;
import com.lsc.backhome.model.entity.Comment;
import com.lsc.backhome.model.entity.RegisteredUser;
import com.lsc.backhome.model.vo.CommentVO;
import com.lsc.backhome.service.CommentService;
import com.lsc.backhome.service.RegisteredUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.lsc.backhome.jwt.JwtUtil.USER_NAME;

@RestController
@RequestMapping("/comments")
public class CommentsController extends BaseController {

    @Resource
    private CommentService commentService;
    @Resource
    private RegisteredUserService registeredUserService;

    @GetMapping("/get_comments")
    public ApiResult<List<CommentVO>> getCommentsBySiteID(@RequestParam(value = "siteid") Integer siteid) {
        List<CommentVO> comment = commentService.getCommentsBySiteID(siteid);
        return ApiResult.success(comment);
    }
    @PostMapping("/add_comment")
    public ApiResult<Comment> add_comment(@RequestHeader(value = USER_NAME) String userName,
                                             @RequestBody CommentDTO dto) {
        RegisteredUser user = registeredUserService.getUserByUsername(userName);
        Comment comment = commentService.create(dto, user);
        return ApiResult.success(comment);
    }
}
