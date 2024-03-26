package com.wms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wms.common.Csachieve;
import com.wms.common.Result;
import com.wms.entity.Menu;
import com.wms.entity.User;
import com.wms.service.MenuService;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }

    //增
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        return userService.save(user)?Result.suc():Result.fail();
    }
    //改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return userService.updateById(user);
    }
    //增或改
    @PostMapping("/saveormod")
    public Result saveOrMod(@RequestBody User user){
        return userService.saveOrUpdate(user)?Result.suc():Result.fail();
    }
    //删
    @GetMapping("/delete")
    public Result delete(@RequestParam String id){
        return userService.removeById(id)?Result.suc():Result.fail();
    }
    //查
    @PostMapping("/listp")
    public Result listP(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(user.getName())) {
            lambdaQueryWrapper.like(User::getName, user.getName());
        }
        if(Objects.nonNull(user.getSex())) {
            lambdaQueryWrapper.eq(User::getSex, user.getSex());
        }
        if(Objects.nonNull(user.getRoleId())) {
            lambdaQueryWrapper.eq(User::getRoleId, user.getRoleId());
        }
        return Result.suc(userService.list(lambdaQueryWrapper));
    }
    //登录
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        List list=userService.lambdaQuery().eq(User::getNo,user.getNo()).eq(User::getPassword,user.getPassword()).list();
        if(list.size()>0) {
            User user1=(User)list.get(0);
            List menuList = menuService.lambdaQuery().like(Menu::getMenuright, user1.getRoleId()).list();
            HashMap res=new HashMap();
            res.put("user",user1);
            res.put("menu",menuList);
            return Result.suc(res);
        }
        return Result.fail();
    }
    //入参封装
    /*@PostMapping("/listpage")
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
    }*/
    @GetMapping("/awvs")
    public Result awvs(){
        return Result.suc();
    }
    @GetMapping("/as")
    public Result as(){
        return Result.suc();
    }
    @GetMapping("/cs")
    public Result cs(){
        Csachieve.main();
        return Result.suc();
    }
    @GetMapping("/awa")
    public Result awa(){
        return Result.suc();
    }
}
