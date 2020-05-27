package dao;

import entity.Movie;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovieDao {
    //根据mid查询电影信息
    Movie selectMovieByMid(int mid);

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

    //list显示电影信息，每页5条
    List<Movie> listMovie(int begin);

    //list显示所有电影信息
    List<Movie> listAllMovie();

    //计算电影总数
    int countMovie();

    //范围查电影
    List<Movie> listMovieByLimit(@Param("begin") int begin,@Param("end") int end);

    //关键字搜索
    List<Movie> searchMovieByName(String s);

    //最大电影id
    int maxMovieId();
}
