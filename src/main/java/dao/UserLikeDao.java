package dao;

import entity.UserLike;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLikeDao {
    //insert一条
    int insertUserLike(@Param("uid") int uid,@Param("mid") int mid,@Param("title") String title);
    //搜索所有
    List<UserLike> listAllUserLikeUserId(int uid);
    //根据uid和mid查记录存在不存在
    UserLike selectUserLikeByUidMid(@Param("uid") int uid,@Param("mid") int mid);
    //删除用户收藏记录
    void deleteUserLike(@Param("uid") int uid,@Param("mid") int mid);
}
