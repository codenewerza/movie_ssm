package dao;

import entity.MovieDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieDtoDao {
    //五张表连接查询电影详细信息
    List<MovieDto> selectMovieInfoByType(@Param("type") String type,@Param("begin") int begin,@Param("num") int num);
    //按类型查询电影个数
    List<Integer> countMovieByType(String type);
}
