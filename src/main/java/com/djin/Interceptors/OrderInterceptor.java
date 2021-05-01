package com.djin.Interceptors;

import com.djin.pojo.User;
import com.djin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("PRE HANDLE");

        User customer = (User) request.getSession().getAttribute("currentUser");

        if(customer == null){
            //user not login
            request.setAttribute("errorMsg","Please login to place order");
            request.getRequestDispatcher("/toLogin.htm").forward(request,response);
            return false;
        }else{
            String ticketID = request.getParameter("ticketID");
            String restaurantID = request.getParameter("restaurantID");
            String orderCategory = request.getParameter("orderCategory");
            String selectedDate = request.getParameter("selectedDate");
            String selectedTime = request.getParameter("selectedTime");
            System.out.println(selectedDate);
            System.out.println(selectedTime);
            Date currentTime = new Date();
            DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat df2 = new SimpleDateFormat("HH:mm");
            Date sDate = df1.parse(selectedDate);
            Date sTime = df2.parse(selectedTime);
            System.out.println(currentTime);
            System.out.println(sDate.toString());
            System.out.println(sTime.toString());
            Date open = df2.parse("8:00");
            Date close = df2.parse("22:00");
            if(orderCategory.equals("1")){

                if(sDate.before(currentTime)){
                    request.setAttribute("errorMsg","Selected Date cannot before today, please try again");
                    request.getRequestDispatcher("/restaurantDetail.htm?restaurantID="+restaurantID).forward(request,response);
                    return false;
                }else if(sTime.getTime() > close.getTime() || sTime.getTime() < open.getTime()){
                    request.setAttribute("errorMsg","Selected Time out of opening time, please try again");
                    request.getRequestDispatcher("/restaurantDetail.htm?restaurantID="+restaurantID).forward(request,response);
                    return false;
                }

            }else if(orderCategory.equals("2")){
                if(sDate.before(currentTime)){
                    request.setAttribute("errorMsg","Selected Date cannot before today, please try again");
                    request.getRequestDispatcher("/ticketDetail.htm?ticketID="+ticketID).forward(request,response);
                    return false;
                }else if(sTime.getTime() > close.getTime() || sTime.getTime() < open.getTime()){
                    request.setAttribute("errorMsg","Selected Time out of opening time,please try again");
                    request.getRequestDispatcher("/ticketDetail.htm?ticketID="+ticketID).forward(request,response);
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
