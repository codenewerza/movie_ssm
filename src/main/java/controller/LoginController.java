package controller;


import entity.HotMovie;
import exception.LoginException.LoginPasswordException;
import exception.LoginException.LoginUsernameException;
import exception.UserException.UserInsertException;
import exception.UserException.UserRepeatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.HotMovieService;
import service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/lg")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private HotMovieService hotMovieService;


    /*
    zhuce   注册页面
    404     异常页面
    main    user主菜单
     */
    @RequestMapping(value = "/zc")
    public String zhuce(String username, String password, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        boolean b = username.equals("")&&password.equals("");
        System.out.println("b为"+b);
        System.out.println("username为"+username);
        System.out.println("password为"+password);
        if(username.equals("")||password.equals("")){
            //model.addAttribute("error_cause","用户名和密码不能为空");
            response.getWriter().print("<script>alert('用户名和密码不能为空');</script>");
            return "redirect:/lg/tz";
        }
        try {
            int res = userService.insertUser(username,password);
        } catch (UserRepeatException e) {
            //model.addAttribute("error_cause",e.getMessage());

            String s = e.getMessage();
            response.getWriter().print("<script>alert('"+s+"');</script>");
            return "redirect:/lg/tz";
        } catch (UserInsertException e){
            //model.addAttribute("error_cause",e.getMessage());

            String s = e.getMessage();
            response.getWriter().print("<script>alert('"+s+"');</script>");
            return "redirect:/lg/tz";
        }
        return "login";
    }


    /*
    登录
    要把userid添加到session或cookie中去
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username,String password,HttpServletResponse response) throws IOException {
        if(username.equals("admin")&&password.equals("123456"))
            return "admin";
        response.setContentType("text/html;charset=utf-8");
        System.out.println(username);
        System.out.println(password);
        if(username==null||password==null){
            response.getWriter().print("<script>alert('用户名和密码不能为空');</script>");
            return "login";
        }
        try {
            userService.login(username,password);
        } catch (LoginUsernameException e) {
            String s = e.getMessage();
            response.getWriter().print("<script>alert('"+s+"');</script>");
            return "login";
        }catch (LoginPasswordException e) {

            String s = e.getMessage();
            response.getWriter().print("<script>alert('"+s+"');</script>");
            return "login";
        }
        int userid = userService.selectUserIdByUsername(username);
        //把userid存cache
        Cookie cookie = new Cookie("userid",String.valueOf(userid));
        cookie.setPath("/");
        response.addCookie(cookie);
        return "forward:/lg/main";
    }

    @RequestMapping(value = "/tz")
    public String tz(){
        return "newsier";
    }

    //加载热门电影
    @RequestMapping(value = "/main")
    public String main(Model model){
        List<HotMovie> list = hotMovieService.getHotMovieList();
        /*
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTitle());
        }
         */
        model.addAttribute("hotMovieList",list);
        return "main";
    }
}