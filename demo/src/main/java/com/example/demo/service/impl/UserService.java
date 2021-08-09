package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements IUserService{
    
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> userList() {
        return userMapper.userList();
    }
    
    @Override
    public User getByUserid(String userid) {
        return userMapper.getByUserid(userid);
    }

    @Override
    public boolean delete(String userid) {
        boolean flag = false;
        try {
            if( userMapper.getByUserid(userid)!=null){
                userMapper.delete(userid);
                flag=true;
            }
        } catch (Exception e) {
            log.error("删除失败");
        }
        return flag;
    }

    @Override
    public boolean update(User user) {
        boolean flag = false;
        try {
            userMapper.update(user);
            flag=true;
        } catch (Exception e) {
            log.error("更新失败");
        }
        return flag;
    }

    @Override
    public boolean updatePhoto(String userid, Byte[] portrait) {
        boolean flag = false;
        try {
            userMapper.updatePhoto(userid, portrait);
            flag=true;
        } catch (Exception e) {
            log.error("更新照片失败");
        }
        return flag;
    }

    @Override
    public boolean updateBalance(String userid, int balance) {
        boolean flag = false;
        try {
            userMapper.updateBalance(userid, balance);
            flag=true;
        } catch (Exception e) {
            log.error("更新余额失败");
        }
        return flag;
    }

    @Override
    public boolean add(User user) {
        boolean flag = false;
        try {
            userMapper.add(user);
            flag=true;
        } catch (Exception e) {
            log.error("添加失败");
        }
        return flag;
    }

    
    
}
