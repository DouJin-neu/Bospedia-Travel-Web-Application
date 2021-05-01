package com.djin.controller;

import com.djin.pojo.*;
import com.djin.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ManagerController {

    @Autowired
    UserService userService;

    @Autowired
    TicketService ticketService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    ManagementService managementService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/toAdminLogin")
    public ModelAndView toAdminLogin(){
        System.out.println("Go to admin login");
        return new ModelAndView("Management/adminLogin","message","Welcome to Management System");
    }
    @RequestMapping(value = "/toAdminHome")
    public ModelAndView toAdminHome(HttpServletRequest request, HttpServletResponse response) throws  Exception{

        String errorMsg = (String) request.getAttribute("errorMsg");
        if(errorMsg != null){
            return new ModelAndView("Management/admin_home","errorMsg",errorMsg);
        }
       return new ModelAndView("Management/admin_home");
    }

    @RequestMapping(value = "/adminLogin")
    public ModelAndView adminLogin(HttpServletRequest request, HttpServletResponse response) throws  Exception{

        String email = request.getParameter("admin_email");
        String pwd = request.getParameter("admin_pwd");
        User admin = userService.findUser(email,pwd);
        if(admin != null && admin.getRole() != 0){

            request.getSession().setAttribute("currentUser",admin);

            return new ModelAndView("Management/admin_home","admin",admin);
        } else{
            System.out.println("password not match");
            return new ModelAndView("Management/adminLogin","errorMsg","Password not match, please try again");
        }
    }

    @RequestMapping(value="productListView")
    public ModelAndView productListView(HttpServletRequest request, HttpServletResponse response) throws Exception{

        List<Ticket> productList = ticketService.getAllTicket();
        request.setAttribute("currentView",0);//current view is productList

        return new ModelAndView("Management/productList","productList",productList);
    }


    @RequestMapping(value = "/sortProducts")
    public ModelAndView sortTickets(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String sortMethod = request.getParameter("sortMethod");

        List<Ticket> productList = ticketService.sortTicket(sortMethod);

        request.setAttribute("sortMethod",sortMethod);

        return new ModelAndView("Management/productList","productList",productList);

    }

    @RequestMapping(value = "/categoryFilter")
    public ModelAndView categoryFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String categoryFilter = request.getParameter("categoryFilter");

        List<Ticket> productList = managementService.categoryFilter(categoryFilter);
        request.setAttribute("categoryFilter",categoryFilter);

        return new ModelAndView("Management/productList","productList",productList);

    }

    @RequestMapping(value = "/priceNameFilter")
    public ModelAndView priceNameFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String minPrice = request.getParameter("minPrice");
        String maxPrice = request.getParameter("maxPrice");
        String productName = request.getParameter("productName");

        List<Ticket> productList = managementService.priceNameFilter(productName,minPrice,maxPrice);

        return new ModelAndView("Management/productList","productList",productList);

    }

    @RequestMapping(value = "/idFilter")
    public ModelAndView idFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String productID = request.getParameter("productID");

        List<Ticket> productList = managementService.idFilter(productID);

        return new ModelAndView("Management/productList","productList",productList);

    }

    @RequestMapping(value="toAddProduct")
    public String toAddProduct(){

        return "Management/addProduct";
    }

    @RequestMapping(value = "/addProduct")
    public ModelAndView createProduct(HttpServletRequest request,HttpServletResponse response) throws Exception{

       String productName = request.getParameter("productName");
       String price = request.getParameter("price");
       String introduce = request.getParameter("introduce");
       String tFlag = request.getParameter("availability");
       String sellingDate = request.getParameter("sellingDate");
       String categoryID = request.getParameter("category");
       String timage = "images/"+request.getParameter("image");


        System.out.println(categoryID);

       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       Ticket newProduct = new Ticket();
        newProduct.setTicketName(productName);
        newProduct.setPrice(Double.parseDouble(price));
        newProduct.settIntroduce(introduce);
        newProduct.settFlag(tFlag);
        newProduct.settDate(simpleDateFormat.parse(sellingDate));
        newProduct.setCollect(0);
        newProduct.setCid(Integer.parseInt(categoryID));
        newProduct.setTimage(timage);

        managementService.createProduct(newProduct);

        return new ModelAndView("Management/addProduct_success","newProduct",newProduct);
    }

    @RequestMapping(value = "/toUpdateProduct")
    public ModelAndView toUpdateProduct(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String productID = request.getParameter("productID");
        int id = Integer.parseInt(productID);
        Ticket ticket = ticketService.getTicket(id);


        return new ModelAndView("Management/updateProductInfo","ticket",ticket);
    }


    @RequestMapping(value = "/updateProduct")
    public ModelAndView updateProduct(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String productID = request.getParameter("productID");
        int id = Integer.parseInt(productID);


        String availability = request.getParameter("availability");
        String price = request.getParameter("price");
        String introduce = request.getParameter("introduce");

        managementService.updateProductAva(availability,id);
        managementService.updateProductPrice(Double.parseDouble(price),id);
        managementService.updateProductInfo(introduce,id);

        Ticket updatedProduct = ticketService.getTicket(id);

        return new ModelAndView("Management/updateProduct_success","updatedProduct",updatedProduct);
    }

    @RequestMapping(value = "/changeAvailability")
    public ModelAndView changeAvailability(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String productID = request.getParameter("productID");
        int id = Integer.parseInt(productID);

        Ticket updatedProduct = ticketService.getTicket(id);

        String availability = updatedProduct.gettFlag();
        System.out.println(availability);

        String change = availability.equals("true")? "false":"true";

        managementService.updateProductAva(change,id);

        List<Ticket> productList = ticketService.getAllTicket();

        return new ModelAndView("Management/productList","productList",productList);
    }

    @RequestMapping(value = "deleteProduct")
    public ModelAndView deleteProduct(HttpServletRequest request,HttpServletResponse response) throws IOException{

        String productID = request.getParameter("productID");
        int id = Integer.parseInt(productID);
        Ticket ticket = ticketService.getTicket(id);

        managementService.deleteProduct(ticket);

        List<Ticket> productList = ticketService.getAllTicket();
        return new ModelAndView("Management/productList","productList",productList);
    }

    @RequestMapping(value="toUserListView")
    public ModelAndView toUserListView(HttpServletRequest request, HttpServletResponse response) throws Exception{

        List<User> userList = userService.getAllUser();
        for(User user:userList){
            System.out.println(user.getUserID());
        }
        request.setAttribute("currentView",1);//current view is userList

        return new ModelAndView("Management/userList","userList",userList);
    }

    @RequestMapping(value = "/userIDFilter")
    public ModelAndView userIDFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String userID = request.getParameter("userID");
        int id = Integer.parseInt(userID);

       List<User> userList = new ArrayList<>();
       userList.add(userService.getUser(id));

        return new ModelAndView("Management/userList","userList",userList);

    }

    @RequestMapping(value = "/userNameFilter")
    public ModelAndView userNameFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String userName = request.getParameter("userName");

        List<User> userList = userService.findUserByName(userName);

        return new ModelAndView("Management/userList","userList",userList);

    }

    @RequestMapping(value = "/userRoleFilter")
    public ModelAndView userRoleFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String userRole = request.getParameter("userRole");

        List<User> userList = userService.findUserByRole(userRole);

        request.setAttribute("userRole",userRole);

        return new ModelAndView("Management/userList","userList",userList);

    }

    @RequestMapping(value="toAddUser")
    public String toAddUser(){

        return "Management/addUser";
    }

    @RequestMapping(value = "/addUser")
    public ModelAndView addUser(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String role = request.getParameter("role");
        int roleID = Integer.parseInt(role);
        Date createTime = new Date();

        User newUser = new User();
        newUser.setUname(userName);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setPhone(phone);
        newUser.setBirthday(birthday);
        newUser.setSex(sex);
        newUser.setRole(roleID);
        newUser.setCreateTime(createTime);
        newUser.setUpdateTime(createTime);

       userService.register(newUser);

        return new ModelAndView("Management/addUser_success","newUser",newUser);
    }

    @RequestMapping(value="toUpdateUser")
    public ModelAndView toUpdateUser(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String userID = request.getParameter("userID");
        int id = Integer.parseInt(userID);
        User user = userService.getUser(id);

        return new ModelAndView("Management/updateUserInfo","user",user);
    }

    @RequestMapping(value = "/updateUser")
    public ModelAndView updateUser(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String userID = request.getParameter("userID");
        int id = Integer.parseInt(userID);


        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");
        int roleID = Integer.parseInt(role);

        userService.updateEmail(id,email);
        userService.updatePhoneNum(id,phone);
        userService.updatePassword(id,password);
        userService.updateMember(id,roleID);

        User updatedUser = userService.getUser(id);

        return new ModelAndView("Management/updateUserInfo_success","updatedUser",updatedUser);
    }

    @RequestMapping(value = "deleteUser")
    public ModelAndView deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException{

        String userID = request.getParameter("userID");
        int id = Integer.parseInt(userID);

        userService.deleteUser(id);

        List<User> userList = userService.getAllUser();
        return new ModelAndView("Management/userList","userList",userList);
    }

    @RequestMapping(value="toOrderListView")
    public ModelAndView toOrderListView(HttpServletRequest request, HttpServletResponse response) throws Exception{

        List<Order> orderList = orderService.getAllOrder();

        request.setAttribute("currentView",2);//current view is orderList

        return new ModelAndView("Management/orderList","orderList",orderList);
    }

    @RequestMapping(value = "orderIDFilter")
    public ModelAndView orderIDFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String orderID = request.getParameter("orderID");
        int id = Integer.parseInt(orderID);

        List<Order> orderList = new ArrayList<>();
        orderList.add(orderService.getOrder(id));

        return new ModelAndView("Management/orderList","orderList",orderList);

    }

    @RequestMapping(value = "searchByUserID")
    public ModelAndView searchByUserID(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String userID = request.getParameter("userID");
        int id = Integer.parseInt(userID);

        List<Order> orderList = orderService.findOrderByUserID(id);

        return new ModelAndView("Management/orderList","orderList",orderList);

    }

    @RequestMapping(value = "orderCategoryFilter")
    public ModelAndView orderCategoryFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String category = request.getParameter("category");
        int id = Integer.parseInt(category);

        List<Order> orderList = orderService.categoryFilter(id);
        request.setAttribute("category",category);

        return new ModelAndView("Management/orderList","orderList",orderList);

    }

    @RequestMapping(value = "orderStatusFilter")
    public ModelAndView orderStatusFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String orderStatus = request.getParameter("orderStatus");

        List<Order> orderList = orderService.statusFilter(orderStatus);

        request.setAttribute("orderStatus",orderStatus);

        return new ModelAndView("Management/orderList","orderList",orderList);
    }

    @RequestMapping(value = "/sortOrders")
    public ModelAndView sortOrders(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String sortMethod = request.getParameter("sortMethod");

        List<Order> orderList = orderService.sortOrder(sortMethod);

        request.setAttribute("sortMethod",sortMethod);

        return new ModelAndView("Management/orderList","orderList",orderList);

    }

    @RequestMapping(value = "/toModifyOrders")
    public ModelAndView toModifyOrders(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String orderID = request.getParameter("orderID");
        int id = Integer.parseInt(orderID);
        Order order = orderService.getOrder(id);

        request.setAttribute("currentView",2);//current view is orderList

        return new ModelAndView("Management/modifyOrder","order",order);

    }

    @RequestMapping(value = "/modifyOrders")
    public ModelAndView modifyOrders(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String orderID = request.getParameter("orderID");
        int id = Integer.parseInt(orderID);

        Order before = orderService.getOrder(id);
        double price = before.getTotalPrice() / before.getItemAmount(); //item price


        String selectedDate = request.getParameter("selectedDate");
        String selectedTime = request.getParameter("selectedTime");
        String amount = request.getParameter("amount");
        int itemAmount = Integer.parseInt(amount);
        String contact = request.getParameter("contact");
        String status = request.getParameter("status");
        String party = request.getParameter("party");
        int partyAmount = 0;
        if(!party.isEmpty()){
            partyAmount = Integer.parseInt(party);
        }
        double currentTotal = price * itemAmount;

        orderService.updateSelectedDate(id,selectedDate);
        orderService.updateSelectedTime(id,selectedTime);
        orderService.updateAmount(id,itemAmount);
        orderService.updateContact(id,contact);
        orderService.updateStatus(id,status);
        orderService.updateParty(id,partyAmount);
        orderService.updatePrice(id,currentTotal);
        orderService.updateModifyDate(id);

        Order modifiedOrder = orderService.getOrder(id);


        request.setAttribute("currentView",2);//current view is orderList

        return new ModelAndView("Management/modifyOrder_success","modifiedOrder",modifiedOrder);

    }

    @RequestMapping(value = "deleteOrder")
    public ModelAndView deleteOrder(HttpServletRequest request,HttpServletResponse response) throws IOException{

        String orderID = request.getParameter("orderID");
        int id = Integer.parseInt(orderID);

       orderService.deleteOrder(id);

        List<Order> orderList = orderService.getAllOrder();
        return new ModelAndView("Management/orderList","orderList",orderList);
    }
}
