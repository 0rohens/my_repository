package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Manager;
import com.example.demo.service.IManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/manager")
public class ManagerController {
    @Autowired 
    IManagerService iManagerService;
    
    @RequestMapping(value = "/managerList",method = RequestMethod.GET)
    public List<Manager> managerList(){
        return iManagerService.managerList();
    }
    @RequestMapping(value = "/managerRole",method = RequestMethod.GET)
    public List<Manager> managerRole(@RequestParam("role") int role){
        return iManagerService.getByRole(role);
    }
    @RequestMapping(value = "/manager",method = RequestMethod.GET)
    public Manager manager(@RequestParam("manager") String manager){
        return iManagerService.getByManager(manager);
    }
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String add(@RequestParam("manager") String manager , @RequestParam("password") String password , @RequestParam("role") int role) {
        Manager manager2 = new Manager(manager,password,role);
        if(iManagerService.add(manager2)){
            return manager2.getManager()+"添加成功";
        }
        else{
            return manager2.getManager()+"添加失败";
        }
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(@RequestParam("manager") String manager){
        if(iManagerService.delete(manager)){
            return manager+"删除成功";
        }
        return manager+"删除失败";
    }
    @RequestMapping(value="/update", method=RequestMethod.GET)
    public String update(@RequestParam("manager") String manager , @RequestParam("password") String password , @RequestParam("role") int role) {
        Manager manager2 = new Manager(manager,password,role);
        if(iManagerService.update(manager2)){
            return manager2.getManager()+"更新成功";
        }
        return manager2.getManager()+"更新失败";
    }
    @RequestMapping(value="/add1", method=RequestMethod.GET)
    public String add1(@RequestBody Manager manager){
        if(iManagerService.add(manager)){
            return manager.getManager()+"添加成功";
        }
        return manager.getManager()+"添加失败";
    }
    @RequestMapping(value="/update1", method=RequestMethod.GET)
    public String update1(@RequestBody Manager manager){
        if(iManagerService.update(manager)){
            return manager.getManager()+"更新成功";
        }
        return manager.getManager()+"更新失败";
    }
    
}