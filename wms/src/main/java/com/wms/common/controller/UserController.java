package com.wms.common.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.QueryPageParam;
import com.wms.common.Result;
import com.wms.entity.User;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wms
 * @since 2024-01-07
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }

    //增
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }
    //改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return userService.updateById(user);
    }
    //增或改
    @PostMapping("/saveormod")
    public boolean saveOrMod(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    //删
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return userService.removeById(id);
    }
    //查
    @PostMapping("/listp")
    public List<User> listP(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper.like(User::getName,user.getName());
        return userService.list(lambdaQueryWrapper);
    }
    //入参封装
    @PostMapping("/listpage")
    public Result listPage(@RequestBody QueryPageParam query){
        //System.out.println(query);
        //System.out.println(query.getPageNum());
        //System.out.println(query.getPageSize());
        HashMap param=query.getParam();
        //System.out.println((String)param.get("name"));
        //System.out.println((String)param.get("no"));
        Page<User> page=new Page();
        page.setCurrent(query.getPageSize());
        page.setSize(query.getPageSize());
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,param.get("name"));
        IPage result=userService.page(page,lambdaQueryWrapper);
        //System.out.println(result.getTotal());
        //System.out.println(result.getPages());
        //System.out.println(result.getRecords());
        return Result.suc(result.getRecords(), result.getTotal());
    }
}
