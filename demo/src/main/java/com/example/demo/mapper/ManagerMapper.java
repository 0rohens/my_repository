package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Manager;
import java.util.List;

@Repository
@Mapper
public interface ManagerMapper {
    List<Manager> managerList();
    void delete(String manager);
    void update(Manager manager);
    void add(Manager manager);
    Manager getByManager(String manager);
    List<Manager> getByRole(int role);

}