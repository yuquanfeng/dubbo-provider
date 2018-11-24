package com.nfsq.yqf.dubboprovider.service;

import api.userservice.UserService;
import bean.NFResult;
import bean.User;
import com.alibaba.dubbo.config.annotation.Service;
import com.nfsq.yqf.dubboprovider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public NFResult<User> selectUser(String s) {
        NFResult<User> result = new NFResult<>();
        try{
           User user = userMapper.selectUser(s);
           result.setMessage("调用成功");
           result.setCode("200");
           result.setData(user);
        }catch (Exception e){
            result.setMessage("调用失败");
            result.setCode("500");
        }
        return result;
    }
}
