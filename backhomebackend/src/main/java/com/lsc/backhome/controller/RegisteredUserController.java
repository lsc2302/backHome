package com.lsc.backhome.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.lsc.backhome.common.api.ApiResult;
import com.lsc.backhome.model.dto.LoginDTO;
import com.lsc.backhome.model.dto.RegisterDTO;
import com.lsc.backhome.model.entity.RegisteredUser;
import com.lsc.backhome.model.vo.ProfileVO;
import com.lsc.backhome.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.lsc.backhome.jwt.JwtUtil.USER_NAME;

@RestController
@RequestMapping("/user")
public class RegisteredUserController {
    @Resource
    private RegisteredUserService registeredUserService;

    @Autowired
    private HttpServletRequest request;


    @PostMapping("/register")
    public ApiResult<Map<String, Object>> register(@Valid @RequestBody RegisterDTO dto) {
        RegisteredUser user = registeredUserService.executeRegister(dto);
        if (ObjectUtils.isEmpty(user)) {
            return ApiResult.failed("Registration Failed");
        }
        Map<String, Object> map = new HashMap<>(16);
        map.put("user", user);
        return ApiResult.success(map);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult<Map<String, String>> login(@Valid @RequestBody LoginDTO dto) {
        String token = registeredUserService.executeLogin(dto);
        if (ObjectUtils.isEmpty(token)) {
            return ApiResult.failed("Error!");
        }
        Map<String, String> map = new HashMap<>(16);
        map.put("token", token);
        return ApiResult.success(map, "Success!");
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ApiResult<ProfileVO> getUserProfile(@RequestHeader(value = USER_NAME) String userName) {
        ProfileVO profile = registeredUserService.getUserProfile(userName);
        return ApiResult.success(profile);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ApiResult<Object> logOut() {
        return ApiResult.success(null, "Success");
    }
}
