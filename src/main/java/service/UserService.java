package service;

import entity.User;
import entity.UserLike;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    //查所有用户信息
    List<User> listAllUser();
    //注册时候插入一条user
    int insertUser(String username,String password);
    //user根据id查信息
    User selectUserById(int userid);
    //管理员分页查user
    List<User> selectUserByLimit(int begin,int end);
    //user修改user信息
    void updateUser(int userid,String password,long phone,String sex,String email);
    //管理员删除用户
    void deleteUserById(int userid);
    //login操作
    void login(String username,String password);
    //根据用户名查id,存cache中
    int selectUserIdByUsername(String username);
    //加一条收藏记录
    int insertUserLike(int uid,int mid,String title);
    //查询用户的所有收藏
    List<UserLike> listUserLike(int uid);
    //删除用户收藏
    void deleteUserLike(int uid,int mid);
}
