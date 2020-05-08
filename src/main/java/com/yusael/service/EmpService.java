package com.yusael.service;

import com.yusael.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findAll();
    void save(Emp emp);
    void delete(String id);
    Emp find(String id);
    void update(Emp emp);
}
