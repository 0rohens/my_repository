package com.example.demo.mapper;

import java.util.List;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    List<User> userList();
    void delete(String userid);
    void update(User user);
    void updatePhoto(String userid,Byte[] portrait);
    void updateBalance(String userid,int balance);
    void add(User user);
    User getByUserid(String userid);
}