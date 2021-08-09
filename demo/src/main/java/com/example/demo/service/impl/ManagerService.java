package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.entity.Manager;
import com.example.demo.mapper.ManagerMapper;
import com.example.demo.service.IManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ManagerService implements IManagerService{
    
    @Autowired 
    private ManagerMapper managerMapper;
    
    @Override
    public List<Manager> managerList() {
        return managerMapper.managerList();
    }

    @Override
    public boolean delete(String manager) {
        boolean flag = false;
        try {
            if(managerMapper.getByManager(manager)!=null)
            {
                managerMapper.delete(manager);
                flag = true;
            }
            log.error("删除失败，管理员不存在");
        } catch (Exception e) {
            log.error("删除失败");
        }
        return flag;
    }

    @Override
    public boolean update(Manager manager) {
        boolean flag = false;
        try {
            managerMapper.update(manager);
            flag = true;
        } catch (Exception e) {
            log.error("更新失败");
        }
        return flag;
    }

    @Override
    public boolean add(Manager manager) {
        boolean flag = false;
        try {
            managerMapper.add(manager);
            flag = true;
        } catch (Exception e) {
            log.error("添加失败");
        }
        return flag;
    }

    @Override
    public Manager getByManager(String manager) {
        return managerMapper.getByManager(manager);
    }

    @Override
    public List<Manager> getByRole(int role) {
        return managerMapper.getByRole(role);
    }

}
