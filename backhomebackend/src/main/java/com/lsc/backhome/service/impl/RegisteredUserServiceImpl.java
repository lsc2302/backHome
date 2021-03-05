package com.lsc.backhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsc.backhome.common.exception.ApiAsserts;
import com.lsc.backhome.jwt.JwtUtil;
import com.lsc.backhome.mapper.RegisteredUserMapper;
import com.lsc.backhome.model.dto.LoginDTO;
import com.lsc.backhome.model.dto.RegisterDTO;
import com.lsc.backhome.model.entity.RegisteredUser;
import com.lsc.backhome.model.vo.ProfileVO;
import com.lsc.backhome.service.RegisteredUserService;
import com.lsc.backhome.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RegisteredUserServiceImpl extends ServiceImpl<RegisteredUserMapper, RegisteredUser> implements RegisteredUserService {

    @Override
    public ProfileVO getUserProfile(String username){
        ProfileVO profile = new ProfileVO();
        RegisteredUser user = baseMapper.selectOne(new LambdaQueryWrapper<RegisteredUser>().eq(RegisteredUser::getUsername, username));
        BeanUtils.copyProperties(user, profile);
        return profile;
    }

    @Override
    public RegisteredUser getUserByUsername(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<RegisteredUser>().eq(RegisteredUser::getUsername, username));
    }

    @Override
    public RegisteredUser executeRegister(RegisterDTO dto){
        LambdaQueryWrapper<RegisteredUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RegisteredUser::getUsername, dto.getName());
        RegisteredUser user = baseMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(user)) {
            ApiAsserts.fail("User Existed！");
        }
        RegisteredUser addUser = RegisteredUser.builder()
                .username(dto.getName())
                .password(MD5Utils.getPwd(dto.getPass()))
                .createTime(new Date())
                .build();
        baseMapper.insert(addUser);
        return addUser;
    }

    @Override
    public String executeLogin(LoginDTO dto){
        String token = null;
        try {
            RegisteredUser user = getUserByUsername(dto.getUsername());
            String encodePwd = MD5Utils.getPwd(dto.getPassword());
            if(!encodePwd.equals(user.getPassword()))
            {
                throw new Exception("密码错误");
            }
            token = JwtUtil.generateToken(String.valueOf(user.getUsername()));
        } catch (Exception e) {
            log.warn("用户不存在or密码验证失败=======>{}", dto.getUsername());
        }
        return token;
    }


}
