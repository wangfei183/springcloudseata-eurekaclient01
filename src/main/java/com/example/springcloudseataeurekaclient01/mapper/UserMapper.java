package com.example.springcloudseataeurekaclient01.mapper;

import com.example.springcloudseataeurekaclient01.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王飞
 * @since 2020-09-24
 */
@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
