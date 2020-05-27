package service;

import entity.Movie;
import entity.MovieDto;

import java.util.Date;
import java.util.List;

public interface MovieService {
    //按标签分类显示movie
    List<MovieDto> listMovieByType(String type,String page);
    //按类型查电影个数
    int countMovieByType(String type);
    //按id查信息
    Movie selectMovieById(int mid);
    //查电影总数
    int countMovie();
    //查限定范围电影
    List<Movie> selectListMovieByLimit(int page);
    //删除电影
    void deleteMovieById(int mid);
    //关键字搜索
    List<Movie> searchMovieByName(String s);
    //insert新电影
    int insertMovie(String title, double rating, Date releasedate, String introduction);
}
