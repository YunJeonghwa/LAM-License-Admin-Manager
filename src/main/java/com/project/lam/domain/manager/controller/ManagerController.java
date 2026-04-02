package com.project.lam.domain.manager.controller;

import com.project.lam.common.exception.ApiResponse;
import com.project.lam.domain.manager.model.Manager;
import com.project.lam.domain.manager.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/managers")
public class ManagerController {

    private final ManagerService managerService;

   @GetMapping("/{id}")
    public ApiResponse getManager(@PathVariable String id){
        return  ApiResponse.ok(managerService.getById(id));
   }


    @PostMapping
    public ApiResponse createManager(@RequestBody Manager manager){
        managerService.create(manager);
        return ApiResponse.ok();
    }


}
