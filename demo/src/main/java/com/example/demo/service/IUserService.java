package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.User;

public interface IUserService {
    List<User> userList();
    boolean delete(String userid);
    boolean update(User user);
    boolean updatePhoto(String userid,Byte[] portrait);
    boolean updateBalance(String userid,int balance);
    boolean add(User user);
    User getByUserid(String userid);
}
