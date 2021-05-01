package com.djin.Interceptors;

import com.djin.pojo.User;
import com.djin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("PRE HANDLE");

        String email = request.getParameter("admin_email");
        String pwd = request.getParameter("admin_pwd");
        User user = userService.findUser(email,pwd);
        if(!userService.isExist(email) ){
            request.setAttribute("errorMsg","Account not exist");
            request.getRequestDispatcher("/toAdminLogin.htm").forward(request,response);
            return false;
        }else{
            if(user == null){

                request.setAttribute("errorMsg","Password not match, please try again");
                request.getRequestDispatcher("/toAdminLogin.htm").forward(request,response);
                return false;

            }else{
                if(user.getRole() == 0){
                    request.setAttribute("errorMsg","You are not a staff");
                    request.getRequestDispatcher("/toLogin.htm").forward(request,response);
                    return false;
                }
            }
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("POST HANDLE");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AFTER HANDLE");
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    }
}
