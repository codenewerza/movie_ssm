package controller;

import entity.HotMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.HotMovieService;

@Controller
@RequestMapping("/hotMovie")
public class HotMovieController {

    @Autowired
    private HotMovieService hotMovieService;

    //路径传参避免和数据库中字段一样，是个坑
    @RequestMapping("/Info/{harmonie}")
    public String hotMovieInfo(Model model, @PathVariable("harmonie") int harmonie){
        //System.out.println("当前拿到的hotmovie是"+hotmovie);
        HotMovie hotMovie = hotMovieService.selectHotMovieById(harmonie);
        model.addAttribute("movie",hotMovie);
        return "hotMovieInfo";
    }
}