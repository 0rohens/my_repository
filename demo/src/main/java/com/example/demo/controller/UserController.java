package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    
    @Autowired 
    IUserService iUserService;
    
    @RequestMapping(value = "/userList",method = RequestMethod.GET)
    public List<User> managerList(){
        return iUserService.userList();
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public User user(@RequestParam("userid") String userid){
        return iUserService.getByUserid(userid);
    }
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String add(@RequestParam("userid") String userid , @RequestParam("nickname") String nickname , 
                      @RequestParam("password") String password , @RequestParam("gender") String gender ,
                      @RequestParam("phone") String phone) 
        {
        User user = new User(userid,nickname,password,gender,phone);
        if(iUserService.add(user)){
            return user.getUserid()+"添加成功";
        }
        else{
            return user.getUserid()+"添加失败";
        }
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(@RequestParam("userid") String userid){
        if(iUserService.delete(userid)){
            return userid+"删除成功";
        }
        return userid+"删除失败";
    }

    @RequestMapping(value="/update", method=RequestMethod.GET)
    public String update(@RequestParam("userid") String userid , @RequestParam("nickname") String nickname , 
                      @RequestParam("password") String password , @RequestParam("gender") String gender ,
                      @RequestParam("phone") String phone) 
        {
        User user = new User(userid,nickname,password,gender,phone);
        if(iUserService.update(user)){
            return user.getUserid()+"更新基本信息成功";
        }
        else{
            return user.getUserid()+"更新基本信息失败";
        }
    }

    @RequestMapping(value="/updateBalance", method=RequestMethod.GET)
    public String updateBalance(@RequestParam("userid") String userid , @RequestParam("balance") int balance) 
        {
        if(iUserService.updateBalance(userid,balance)){
            return userid+"更新余额成功";
        }
        else{
            return userid+"更新余额失败";
        }
    }

    @RequestMapping(value="/updatePhoto", method=RequestMethod.GET)
    public String updatePhoto(@RequestParam("userid") String userid , @RequestParam("photo") Byte[] photo) 
        {
        if(iUserService.updatePhoto(userid,photo)){
            return userid+"更新余额成功";
        }
        else{
            return userid+"更新余额失败";
        }
    }

    @RequestMapping(value="/add1", method=RequestMethod.GET)
    public String add1(@RequestBody User user){
        if(iUserService.add(user)){
            return user.getUserid()+"添加成功";
        }
        return user.getUserid()+"添加失败";
    }
    
    @RequestMapping(value="/update1", method=RequestMethod.GET)
    public String update1(@RequestBody User user) 
        {
        if(iUserService.update(user)){
            return user.getUserid()+"更新基本信息成功";
        }
        else{
            return user.getUserid()+"更新基本信息失败";
        }
    }
    
}