package exception;

import com.sun.org.apache.xpath.internal.operations.Mod;
import exception.LoginException.LoginPasswordException;
import exception.LoginException.LoginUsernameException;
import exception.UserException.UserInsertException;
import exception.UserException.UserRepeatException;
import exception.UserLikeException.RepeatLikeException;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    //注册异常

    @ExceptionHandler(UserRepeatException.class)
    public String userRepeatExceptionHandler(Model model, UserRepeatException e){
        model.addAttribute("error",e.getMessage());
        return "redirect:/lg/tz";
    }


    @ExceptionHandler(UserInsertException.class)
    public String userInsertExceptionHandler(Model model,UserInsertException e){
        model.addAttribute("error",e.getMessage());
        return "login";
    }

    //登录异常
    @ExceptionHandler(LoginUsernameException.class)
    public String loginUsernameExceptionHandler(Model model,LoginUsernameException e){
        model.addAttribute("error",e.getMessage());
        return "login";
    }

    @ExceptionHandler(LoginPasswordException.class)
    public String loginPasswordExceptionHandler(Model model,LoginPasswordException e){
        model.addAttribute("error",e.getMessage());
        return "login";
    }

    //用户重复收藏
    @ExceptionHandler(RepeatLikeException.class)
    public String repeatLikeExceptionHandler(Model model,RepeatLikeException e){
        model.addAttribute("error",e.getMessage());
        return "forward:/lg/main";
    }

    @ExceptionHandler(IOException.class)
    public String ioExceptionHandler(Model model,IOException e){
        model.addAttribute("error",e.getMessage());
        return "404";
    }

    @ModelAttribute
    //定义全局对象，任何时候可以通过键值对取得值
    public void getUser(Model model){
        return ;
    }


    @InitBinder
    //应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
    //用来设置WebDataBinder，用于自动绑定前台请求参数到Model中。
    public void initBinder(WebDataBinder binder) {
    }
}
