package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface UserDao {

    //根据userid查询用户信息
    User selectUserByUserId(int userid);

    //增加一条用户信息
    int insertUser(@Param("userid") int userid,@Param("username") String username,@Param("password") String password);


    //查询全部用户信息,分页
    List<User> listUser(@Param("begin") int begin,@Param("end") int end);

    //查询所有用户
    List<User> listAllUser();

    //删除一条用户信息
    void deleteUserByUserId(int userid);

    //用户修改自己的信息,通过userid修改所有信息，不能改用户名
    void updateUser(@Param("userid") int userid,@Param("password") String password,
                    @Param("phone") long phone,@Param("sex") String sex,@Param("email") String email);

    //查最大用户id，插入时候用
    int selectMaxId();

    //通过用户名查用户是否存在，插入时候用
    User selectUserByName(String username);

    //一共多少个user
    int getUserCount();

    //
}
