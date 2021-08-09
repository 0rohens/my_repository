package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Manager;

public interface IManagerService {
    List<Manager> managerList();
    boolean delete(String manager);
    boolean update(Manager manager);
    boolean add(Manager manager);
    Manager getByManager(String manager);
    List<Manager> getByRole(int role);
}