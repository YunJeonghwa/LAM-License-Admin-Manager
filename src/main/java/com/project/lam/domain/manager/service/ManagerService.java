package com.project.lam.domain.manager.service;

import com.project.lam.domain.manager.mapper.ManagerMapper;
import com.project.lam.domain.manager.model.Manager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagerService {

    private final ManagerMapper managerMapper;

    public ManagerService(ManagerMapper managerMapper){
        this.managerMapper = managerMapper;
    }

    public Manager getById(String id){
        return managerMapper.findById(id);
    }

    @Transactional
    public void create(Manager manager){
        managerMapper.insert(manager);
    }
}
