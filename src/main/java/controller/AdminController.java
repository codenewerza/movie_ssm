package controller;

import entity.HotMovie;
import entity.Movie;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.HotMovieService;
import service.MovieService;
import service.UserService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private HotMovieService hotMovieService;


    @RequestMapping("/uc")
    public String userList(Model model){
        List<User> list = userService.listAllUser();
        model.addAttribute("list",list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("用户名为"+list.get(i).getUsername());
        }
        return "userList";
    }

    @RequestMapping("/du/{uid}")
    public String deleteUserById(@PathVariable("uid") int uid){
        userService.deleteUserById(uid);
        return "forward:/admin/uc";
    }


    @RequestMapping("/mc/{ppp}")
    public String movieList(Model model, @PathVariable("ppp") String ppp){
        int page = Integer.valueOf(ppp);
        int count_num = movieService.countMovie();
        int count_page = count_num/5;
        if(count_num%5!=0)
            count_page++;
        if(page>count_page)
            page = count_page;
        int next_page = page+1>count_page?count_page:page+1;
        int front_page = page-1<1?1:page-1;


        List<Movie> list = movieService.selectListMovieByLimit(page);
        model.addAttribute("movie_list",list);
        model.addAttribute("front_page",front_page);
        model.addAttribute("next_page",next_page);
        return "adminListMovie";
    }

    @RequestMapping("/showMovieInfo/{mid}")
    public String showMovieInfo(Model model,@PathVariable("mid") int mid){
        Movie movie = movieService.selectMovieById(mid);
        model.addAttribute("m",movie);
        return "adminMovieInfo";
    }


    @RequestMapping("/dm/{mid}")
    public String deleteMovie(@PathVariable("mid") int mid){
        movieService.deleteMovieById(mid);
        return "forward:/admin/mc/1";
    }


    @RequestMapping("/hmc")
    public String hotMovieList(Model model){
        List<HotMovie> list = hotMovieService.listAllHotMovie();
        model.addAttribute("list",list);
        return "adminHotMovieList";
    }

    @RequestMapping("/dhm/{mid}")
    public String deleteHotMovie(@PathVariable("mid") int mid){
        hotMovieService.deleteHotMovieById(mid);
        return "forward:/admin/hmc";
    }

    @RequestMapping("/showHotMovieInfo/{mid}")
    public String showHotMovieInfo(Model model,@PathVariable("mid") int mid){
        HotMovie hotmovie = hotMovieService.selectHotMovieById(mid);
        model.addAttribute("movie",hotmovie);
        return "adminHotMovieInfo";
    }

    @RequestMapping("/addMovie")
    public String addMovie(){
        return "addMovieInfo";
    }

    @RequestMapping("/addMovieInfo")
    public String addMovieInfo(Model model, String title, double rating, Date releasedate,String introduction){
        hotMovieService.insertMovie(title,rating,releasedate,introduction);
        return "admin";
    }

    @RequestMapping("/addHotMovie")
    public String addHotMovie(){
        return "addMovieHotInfo";
    }

    @RequestMapping("/addHotMovieInfo")
    public String addMovieHotInfo(Model model, String title, double rating, Date releasedate,String introduction){
        hotMovieService.insertMovie(title,rating,releasedate,introduction);
        return "admin";
    }
}
