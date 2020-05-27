package dao;

import entity.HotMovie;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
//对于热门电影的操作，和普通电影差不多
public interface HotMovieDao {
    //根据mid查询电影信息
    HotMovie selectMovieByMid(int mid);

    //查询电影类别,将movie_to_genre和genre连接然后求类别
    List<String> selectMovieByGenre(int mid);

    //增加一条电影信息
    int insertMovie(@Param("mid") long mid, @Param("title") String title,
                    @Param("introduction") String introduction, @Param("rating") double rating,
                    @Param("releasedate") Date releasedate);

    //修改电影信息
    void updateMovie(@Param("mid") long mid, @Param("title") String title,
                     @Param("introduction") String introduction, @Param("rating") double rating,
                     @Param("releasedate") Date releasedate);

    //删除电影信息
    void deleteMovie(long mid);

    //list显示电影信息
    List<HotMovie> listMovie(@Param("begin") int begin, @Param("end") int end);

    //list显示所有电影信息
    List<HotMovie> listAllMovie();

    //一共多少hotmovie
    int countHotMovie();

    //最大电影id
    int maxMovieId();
}
