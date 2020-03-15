package com.zhbit.scratch.dao;

import com.zhbit.scratch.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface UserDao {

    User selectUser(Map<String, String> userParam);

    int countByLoginName(@Param("email") String loginMail);

    void updatePassword(String userId, String password);

    void addUser(User user);
}
