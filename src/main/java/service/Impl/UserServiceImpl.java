package service.Impl;

import dao.UserDao;
import dao.UserLikeDao;
import entity.User;
import entity.UserLike;
import exception.LoginException.LoginPasswordException;
import exception.LoginException.LoginUsernameException;
import exception.UserException.UserInsertException;
import exception.UserException.UserRepeatException;
import exception.UserLikeException.RepeatLikeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Autowired
    public UserLikeDao userLikeDao;

    @Override
    public int insertUser(String username, String password) throws UserRepeatException, UserInsertException {
        User user = userDao.selectUserByName(username);
        if(user!=null){
            throw new UserRepeatException("该用户名已被注册过");
        }
        int maxid = userDao.selectMaxId();
        int curid = maxid+1;
        int res = 0;

        try {
            res = userDao.insertUser(curid,username,password);
        } catch (Exception e) {
            throw new UserInsertException("注册新用户失败");
        }
        return res;
    }

    @Override
    public User selectUserById(int userid) {
        User user = userDao.selectUserByUserId(userid);
        return user;
    }

    //这个end是指要获取的最后一个user，begin为第一个user在表中的位置，end为最后一个
    @Override
    public List<User> selectUserByLimit(int begin, int end) {
        int count = userDao.getUserCount();
        List<User> list = null;
        if(begin>count) {
            return null;
        }else if(begin<count&&end>count){
            list = userDao.listUser(begin,count);
            return list;
        }else{
            list = userDao.listUser(begin,end);
            return list;
        }
    }

    //修改操作如果有的项不填，就select原数据update
    @Override
    public void updateUser(int userid, String password, long phone, String sex, String email) {
        User user = userDao.selectUserByUserId(userid);
        if(password==null){
            password = user.getPassword();
        }
        if(phone==0){
            phone = user.getPhone();
        }
        if(sex==null){
            sex = user.getSex();
        }
        if(email==null){
            email = user.getEmail();
        }
        userDao.updateUser(userid,password,phone,sex,email);
    }

    @Override
    public void deleteUserById(int userid) {
        userDao.deleteUserByUserId(userid);
    }

    @Override
    public void login(String username,String password) throws LoginUsernameException,LoginPasswordException {
        User user = userDao.selectUserByName(username);
        if(user==null){
            throw new LoginUsernameException("用户名不存在");
        }
        if(!password.equals(user.getPassword())){
            System.out.println(user.getPassword());
            throw new LoginPasswordException("密码错误");
        }else {
            return;
        }
    }
    //这个操作已经经过检验了，不抛异常
    @Override
    public int selectUserIdByUsername(String username){
        User user = userDao.selectUserByName(username);
        return user.getUserid();
    }

    //增加一条收藏记录
    @Override
    public int insertUserLike(int uid,int mid,String title) throws RepeatLikeException {
        UserLike userLike = userLikeDao.selectUserLikeByUidMid(uid,mid);
        if(userLike!=null){
            throw new RepeatLikeException("该电影已收藏过");
        }
        int res = userLikeDao.insertUserLike(uid,mid,title);
        return res;
    }

    //找user的收藏
    @Override
    public List<UserLike> listUserLike(int uid){
        List<UserLike> list = userLikeDao.listAllUserLikeUserId(uid);
        return list;
    }

    //删除user收藏
    @Override
    public void deleteUserLike(int uid,int mid){
        userLikeDao.deleteUserLike(uid,mid);
        return;
    }

    @Override
    public List<User> listAllUser(){
        List<User> list = userDao.listAllUser();
        return list;
    }
}
