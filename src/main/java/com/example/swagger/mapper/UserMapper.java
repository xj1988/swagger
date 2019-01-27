package com.example.swagger.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.swagger.pojo.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    List<User> selectByPrimaryKey(String id);
//
//    int deleteByPrimaryKey(String id);
//
//    int insertSelective(User record);
//
//    List<User> selectByParams(User user);
//
//    int updateByPrimaryKeySelective(User record);

}