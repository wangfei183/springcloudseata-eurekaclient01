package com.example.springcloudseataeurekaclient01.service.impl;

import com.example.springcloudseataeurekaclient01.bean.User;
import com.example.springcloudseataeurekaclient01.mapper.UserMapper;
import com.example.springcloudseataeurekaclient01.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王飞
 * @since 2020-09-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
