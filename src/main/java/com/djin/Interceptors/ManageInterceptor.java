package com.djin.Interceptors;

import com.djin.pojo.User;
import com.djin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageInterceptor extends HandlerInterceptorAdapter {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("PRE HANDLE");

        String price = request.getParameter("price");
        String availability = request.getParameter("availability");
        String introduction = request.getParameter("introduce");
        String productId = request.getParameter("productID");

        if(price == null || availability == null || introduction == null){
            request.setAttribute("errorMsg","Please fill all the fields");
            request.getRequestDispatcher("/updateProduct.htm?productID="+productId).forward(request,response);
            return false;
        }else if (!price.matches("^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$")){
            request.setAttribute("errorMsg","Price can only contains digits");
            request.getRequestDispatcher("/updateProduct.htm?productID="+productId).forward(request,response);
            return false;
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
