package com.example.swagger.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.example.swagger.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserService extends IService {

    List<User> getUser(Wrapper wapper);

    int createUser(User user);

    int deleteUser(String id);

    int updateUser(User user);

}
