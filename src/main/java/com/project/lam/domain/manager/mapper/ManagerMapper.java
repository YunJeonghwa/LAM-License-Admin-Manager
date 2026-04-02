package com.project.lam.domain.manager.mapper;

import com.project.lam.domain.manager.model.Manager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerMapper {
    Manager findById(String id);

    void insert(Manager manager);
    }
