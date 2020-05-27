package controller;

import entity.Movie;
import entity.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.MovieService;

import java.util.List;

/*
定义一个电影类型的枚举类
 */

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    //映射type函数
    public String getType(String t){
        if(t.equals("tvmovie"))
            return "电视电影";
        if(t.equals("cartoon"))
            return "动画";
        if(t.equals("western"))
            return "西部";
        return null;
    }

    //按类别获取电影详细信息
    @RequestMapping(value = "/getMovieByType/{type}/{page}" ,method = RequestMethod.GET)
    public String getMovieByType(@PathVariable("type") String type, @PathVariable("page") String page, Model model){
        System.out.println("接收到的参数page为"+page);
        String t = getType(type);
        int p = Integer.valueOf(page);


        //先看总页数够不够，不够就当前页，小于1就当前页
        int count_p = movieService.countMovieByType(t);
        System.out.println("count_p为"+count_p);
        int next_p = p+1>count_p?count_p:p+1;
        int front_p = p-1<1?1:p-1;
        System.out.println("next_p为"+next_p);
        System.out.println("front_p为"+front_p);

        //进行封装
        model.addAttribute("type",type);
        model.addAttribute("page",p);
        model.addAttribute("next_page",next_p);
        model.addAttribute("front_page",front_p);

        List<MovieDto> list = movieService.listMovieByType(t,page);
        model.addAttribute("MovieListByType",list);
        /*
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTitle());
        }

         */
        return "listMovieByType";
    }

    @RequestMapping("/Info/{movie}")
    public String movieInfo(Model model,@PathVariable("movie") int movie){
        Movie movie1 = movieService.selectMovieById(movie);
        model.addAttribute("movieInfo",movie1);
        return "movieByTypeInfo";
    }
}