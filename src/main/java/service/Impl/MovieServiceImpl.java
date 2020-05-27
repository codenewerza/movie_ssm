package service.Impl;
import dao.MovieDao;
import dao.MovieDtoDao;
import entity.Movie;
import entity.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MovieService;

import java.util.Date;
import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDtoDao movieDtoDao;

    @Autowired
    private MovieDao movieDao;

    //page代表页数，一行5页
    @Override
    public List<MovieDto> listMovieByType(String type,String page) {
        int p = Integer.valueOf(page);
        int begin = (p-1)*5;
        List<MovieDto> list = movieDtoDao.selectMovieInfoByType(type,begin,5);
        //begin是开始的那一行，5是一页行数
        return list;
    }

    @Override
    public int countMovieByType(String type){
        List<Integer> list = movieDtoDao.countMovieByType(type);
        int count = list.size();
        //算一下页数
        int res = count/5;
        if(count%5!=0)
            res++;
        return res;
    }

    @Override
    public Movie selectMovieById(int mid){
        Movie movie = movieDao.selectMovieByMid(mid);
        return movie;
    }

    @Override
    public int countMovie(){
        int count = movieDao.countMovie();
        return count;
    }

    @Override
    public List<Movie> selectListMovieByLimit(int page){
        int begin = (page-1)*5;
        int end = 5;
        List<Movie> list = movieDao.listMovieByLimit(begin,end);
        return list;
    }
    @Override
    public void deleteMovieById(int mid){
        movieDao.deleteMovie(mid);
        return;
    }
    @Override
    public List<Movie> searchMovieByName(String s){
        List<Movie> list = movieDao.searchMovieByName(s);
        return list;
    }
    @Override
    public int insertMovie(String title, double rating, Date releasedate, String introduction){
        int max_id = movieDao.maxMovieId();
        int cur_id = max_id+1;
        int res = movieDao.insertMovie(cur_id,title,introduction,rating,releasedate);
        return res;
    }
}
