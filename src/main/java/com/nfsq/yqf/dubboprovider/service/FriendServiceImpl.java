package com.nfsq.yqf.dubboprovider.service;

import api.friendservice.FriendService;
import bean.Friend;
import bean.NFResult;
import com.alibaba.dubbo.config.annotation.Service;
import com.nfsq.yqf.dubboprovider.mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    FriendMapper friendMapper;

    @Override
    public NFResult<Friend> selectFriend(String s) {
        NFResult<Friend> result = new NFResult<>();
        try{
           Friend friend = friendMapper.selectFriend(s);
           result.setData(friend);
           result.setCode("200");
           result.setMessage("调用服务成功");
        }catch (Exception e){
            result.setCode("500");
            result.setMessage("调用服务失败");
        }
        return result;
    }
}
