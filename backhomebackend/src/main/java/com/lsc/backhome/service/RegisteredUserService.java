package com.lsc.backhome.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsc.backhome.model.dto.LoginDTO;
import com.lsc.backhome.model.dto.RegisterDTO;
import com.lsc.backhome.model.entity.RegisteredUser;
import com.lsc.backhome.model.vo.ProfileVO;

public interface RegisteredUserService extends IService<RegisteredUser> {
    RegisteredUser executeRegister(RegisterDTO dto);
    String executeLogin(LoginDTO dto);
    ProfileVO getUserProfile(String id);
    RegisteredUser getUserByUsername(String username);
}
