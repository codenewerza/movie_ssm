package dao;

import entity.Genre;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreDao {
    //根据gid查类别名称
    Genre selectGenreByGid(long gid);
    //计算一共多少种类别
    int countGenreNum();
}
