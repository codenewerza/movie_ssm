package service.Impl;

import dao.HotMovieDao;
import entity.HotMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.HotMovieService;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class HotMovieServiceImpl implements HotMovieService {

    @Autowired
    private HotMovieDao hotMovieDao;

    @Override
    public List<HotMovie> getHotMovieList(){
        int count = hotMovieDao.countHotMovie();
        //随机生成起始点
        Random random = new Random();
        int begin = random.nextInt(count-5);//0-x,不包含x
        List<HotMovie> list = hotMovieDao.listMovie(begin,5);
        return list;
    }

    @Override
    public HotMovie selectHotMovieById(int mid){
        HotMovie hotMovie = hotMovieDao.selectMovieByMid(mid);
        return hotMovie;
    }
    @Override
    public List<HotMovie> listAllHotMovie(){
        List<HotMovie> list = hotMovieDao.listAllMovie();
        return list;
    }
    @Override
    public void deleteHotMovieById(int mid){
        hotMovieDao.deleteMovie(mid);
        return;
    }
    @Override
    public int insertMovie(String title, double rating, Date releasedate, String introduction){
        int max_id = hotMovieDao.maxMovieId();
        int cur_id = max_id+1;
        int res = hotMovieDao.insertMovie(cur_id,title,introduction,rating,releasedate);
        return res;
    }
}
