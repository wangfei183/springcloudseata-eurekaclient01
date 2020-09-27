package com.example.springcloudseataeurekaclient01.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springcloudseataeurekaclient01.accountfeign.AccountFeign;
import com.example.springcloudseataeurekaclient01.accountfeign.AwardFeign;
import com.example.springcloudseataeurekaclient01.bean.Statement;
import com.example.springcloudseataeurekaclient01.bean.User;
import com.example.springcloudseataeurekaclient01.returnmessage.ReturnMessage;
import com.example.springcloudseataeurekaclient01.service.StatementService;
import com.example.springcloudseataeurekaclient01.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王飞
 * @since 2020-09-24
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @Resource
    AccountFeign accountFeign;
    @Resource
    StatementService statementService;
    @Resource
    AwardFeign  awardFeign;


    /*
    * @Description: 注册用户
    * @Param: [user]
    * @return: com.example.springcloudseataeurekaclient01.returnmessage.ReturnMessage
    * @Author: 王飞
    * @Date: 2020/9/24 10:21
    **/
    @RequestMapping("/queryUser")
    @ResponseBody
    public ReturnMessage inserUser(@RequestBody User user){
        QueryWrapper queryWrapper=new QueryWrapper();
        List<User> list =userService.list(queryWrapper);
        return ReturnMessage.success().add("list",list);

    }

    @RequestMapping("/zzMoney")
    @ResponseBody
    @GlobalTransactional
    public ReturnMessage zzMoney(@RequestBody Map<String,Object> map){
        String userId1=map.get("u1").toString();
        String userId2=map.get("u2").toString();
        String money=map.get("money").toString();
        Statement statement =new Statement();
        statement.setCtime(LocalDateTime.now());
        statement.setOutUserId(Integer.valueOf(userId1));
        statement.setInUserId(Integer.valueOf(userId2));
        statement.setMoney(new BigDecimal(money));
        boolean a=statementService.save(statement);
        System.out.println(a);
       return accountFeign.addCart(map);//调用account服务
//       return awardFeign.saveAward(map);

    }





}

