package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import entity.Movie;
import entity.User;
import entity.UserLike;
import exception.UserLikeException.RepeatLikeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.MovieService;
import service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    //user查看自己信息
    @RequestMapping(value = "/Info",method = RequestMethod.GET)
    public String personalUserInfo(Model model,HttpServletRequest request){
        int userid = getUserIdFromCookie(request);
        //不会查不到，登录的时候已经检查过，报错就是cookie被清理或者没存进去
        User user = userService.selectUserById(userid);
        model.addAttribute("user",user);
        return "userInfo";
    }

    @RequestMapping(value = "/modifyUserInfo",method = RequestMethod.GET)
    public String modifyUserInfo(){
        return "modifyUserInfo";
    }

    //user修改信息
    @RequestMapping(value = "/modifyInfo",method = RequestMethod.POST)
    public String modifyPersonalUserInfo(HttpServletRequest request,
                                         String password, long phone, String sex, String email){
        int userid = getUserIdFromCookie(request);
        userService.updateUser(userid,password,phone,sex,email);
        return "redirect:/user/Info";
    }

    //从cookie拿userid
    public int getUserIdFromCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String id = null;
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals("userid")){
                id = cookie.getValue();
                //System.out.println("当前cookie存的userid是"+id);
            }
        }
        int userid = Integer.valueOf(id);
        return userid;
    }


    //用户收藏动作
    @RequestMapping(value = "/like/{mid}/{title}")
    public String addUserLike(HttpServletRequest request, HttpServletResponse response, @PathVariable("mid") int mid, @PathVariable("title") String title) {
        int uid = getUserIdFromCookie(request);
        System.out.println("mid为"+mid);
        System.out.println("title为"+title);
        try {
            userService.insertUserLike(uid, mid, title);
        } catch (RepeatLikeException e) {
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
            } catch (IOException ex) {

            }
            String s = e.getMessage();
            writer.print("<script>alert('" + s + "');</script>");
            return "forward:/lg/main";
        }
        return "forward:/lg/main";
    }

    //用户收藏list
    @RequestMapping("/myLike")
    public String listUserLike(Model model,HttpServletRequest request){
        int uid = getUserIdFromCookie(request);
        List<UserLike> list = userService.listUserLike(uid);
        model.addAttribute("likeList",list);
        return "userLikeMovie";
    }

    //具体收藏信息
    @RequestMapping("/myLikeMovieInfo/{mid}")
    public String myLikeMovieInfo(Model model,@PathVariable("mid") int mid){
        Movie movie = movieService.selectMovieById(mid);
        model.addAttribute("movieInfo",movie);
        return "userLikeMovieInfo";
    }

    //删除收藏电影
    @RequestMapping("/deleteMyLikeMovie/{mid}")
    public String deleteMyLikeMovie(@PathVariable("mid") int mid,HttpServletRequest request){
        int uid = getUserIdFromCookie(request);
        userService.deleteUserLike(uid,mid);
        return "forward:/user/myLike";
    }

    //搜索
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String searchByName(Model model,String x){
        x = '%'+x+'%';
        System.out.println("搜索内容为"+x);
        List<Movie> list = movieService.searchMovieByName(x);
        model.addAttribute("list",list);
        return "movieInfoList";
    }
    @RequestMapping("/searchMovieInfo/{mid}")
    public String searchMovieInfo(Model model,@PathVariable("mid") int mid){
        Movie movie = movieService.selectMovieById(mid);
        model.addAttribute("movieInfo",movie);
        return "movieInfo";
    }
}
