package com.example.swagger.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.swagger.pojo.User;
import com.example.swagger.service.UserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/user")
@Api(value = "/user", description = "对user的操作")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "查询用户", notes = "根据姓名和联系方式查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户姓名", required = false, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "tel", value = "用户联系方式", required = false, dataType = "String", paramType = "path"),
    })
    @GetMapping("/getUser/{name}/{tel}")
    public Object getUser(@PathVariable String name, @PathVariable String tel) {
        Map<String, Object> map = new HashMap<>();
        Wrapper wrapper = new EntityWrapper<User>(); // MP条件构造器
        if(!"{name}".equals(name))
            wrapper.like("name",name);
        if(!"{tel}".equals(tel))
            wrapper.like("tel",tel);
        List<User> userList = userService.getUser(wrapper);
        if(userList.isEmpty())
            map.put("flag", "fail");
        else{
            map.put("flag", "success");
            map.put("data", userList);
        }
        return map;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/createUser")
    public Object createUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        int num = userService.createUser(user);
        if(num>0)
            map.put("flag", "success");
        else
            map.put("flag", "fail");
        return map;
    }

    @ApiOperation(value = "删除用户", notes = "根据url中的id来指定删除图书")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @DeleteMapping("/deleteUser/{id}")
    public Object deleteUser(@PathVariable String id) {
        Map<String, Object> map = new HashMap<>();
        int num = userService.deleteUser(id);
        if(num>0)
            map.put("flag", "success");
        else
            map.put("flag", "fail");
        return map;
    }

    @ApiOperation(value = "更新用户", notes = "根据传到后台的user信息来更新用户详细信息")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PutMapping("/updateUser")
    public Object updateUser(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        int num = userService.updateUser(user);
        if(num>0)
            map.put("flag", "success");
        else
            map.put("flag", "fail");
        return map;
    }

}
