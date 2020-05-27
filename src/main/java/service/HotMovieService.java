package service;

import entity.HotMovie;

import java.util.Date;
import java.util.List;

public interface HotMovieService {
    /*
    随机生成8个热门电影
     */
    List<HotMovie> getHotMovieList();
    //id找电影
    HotMovie selectHotMovieById(int mid);
    //list所有电影
    List<HotMovie> listAllHotMovie();
    //删除
    void deleteHotMovieById(int mid);
    //insert
    int insertMovie(String title, double rating, Date releasedate, String introduction);
}
