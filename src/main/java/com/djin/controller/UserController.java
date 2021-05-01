package com.djin.controller;

import com.djin.pojo.Favorite;
import com.djin.pojo.User;
import com.djin.service.FavoriteService;
import com.djin.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FavoriteService favoriteService;

    @ResponseBody
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String customerRegister(HttpServletRequest request, HttpServletResponse response) throws Exception{

        String res = "";
        String uname = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("telephone");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        int role = 0;
        Date createTime = new Date();
        User user = new User(uname,password,birthday,sex,email,phone,role,createTime,createTime);

        userService.register(user);

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("currentUser",user);

        return res;
    }

    @RequestMapping(value="/userExist",method = RequestMethod.GET)
    public void userExist(String email, HttpServletResponse response) throws Exception{

       boolean isExist = userService.isExist(email);
       if(isExist){
           response.getWriter().write("1");
       }else{
           response.getWriter().write("2");
       }

    }


    @RequestMapping(value = "/customerLogin", method = RequestMethod.POST)
    public ModelAndView customerLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean isExist = userService.isExist(email);
        System.out.println(isExist);
        if(isExist){
            User user = userService.findUser(email,password);
            System.out.println(user.toString());
            if(user != null && user.getRole() == 0){
                //user is customer
                request.getSession().setAttribute("currentUser",user);
                List<Favorite> favoriteList = favoriteService.findFavoriteByUserID(user.getUserID());
                HttpSession session = request.getSession();
                session.setAttribute("favoriteList",favoriteList);
                return new ModelAndView("../../index","successMsg","User login successfully");
            } else{
                System.out.println("password not match");
                return new ModelAndView("customer/login","errorMsg","Password not match, please try again");
            }
        }else{
            System.out.println("account doesn't exist");
            return new ModelAndView("customer/login","errorMsg","Account doesn't exist.");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public String customerInfoUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{

        String res = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        User user = (User) request.getSession().getAttribute("currentUser");
        user.setUname(username);
        user.setPassword(password);
        user.setPhone(phone);

       userService.updateCustomerInfo(user);

        res = "update success";

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("currentUser",user);

        return res;
    }

    @RequestMapping(value = "/updateView",method = RequestMethod.GET)
    public ModelAndView updateView(HttpServletRequest request, HttpServletResponse response) throws Exception{


        return new ModelAndView("customer/updateUserInfo","message","Customer Information update");
    }

    @RequestMapping(value = "/infoView",method = RequestMethod.GET)
    public ModelAndView infoView(HttpServletRequest request, HttpServletResponse response) throws Exception{


        return new ModelAndView("customer/user_info","message","Customer Information update");
    }

}
