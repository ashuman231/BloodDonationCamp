package com.codeplanet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeplanet.model.BloodItem;
import com.codeplanet.model.User;
import com.codeplanet.service.UserService;

@Controller
public class UserController {
@Autowired
UserService userService;
	@PostMapping(value="/userSignup" )
	public String userSignup(HttpServletRequest req,User user) throws SQLException
	{  System.out.println("controller start for signup");
	   System.out.println("controller end for signup");
		if(userService.userSignup(user)==false)
		req.setAttribute("message1","Warn:---- Email already exists.Use another email-id to sign-up for user");		
		else
		req.setAttribute("message1","Warn:---- Signup Successfully for user");
		return "user-login-signup";
	}
	@PostMapping(value="/userLogin")
	public String userLogin(User user, HttpSession session,HttpServletRequest req) throws SQLException, ClassNotFoundException
	{  System.out.println("controller start for login");
	   if(userService.userLogin(user,session)==true)
	   { 
		   System.out.println("login successful");
		   return "user-index"; 
	   }
	   else
	   {   
		   req.setAttribute("message","Warn:---- Invalid Credential");
		   return "user-login-signup"; 
	   }
	}
	@RequestMapping(value="/userLogout")
	public String userLogout(HttpSession session) throws SQLException
	{  System.out.println("controller start for logout");
	  session.invalidate();
	  return "user-login-signup";
	}
	@RequestMapping(value="/addBloodInfo")
	public String addBloodINfo(HttpServletRequest req,BloodItem BloodItem1) throws ClassNotFoundException, SQLException
	{   if(req.getSession().getAttribute("userEmail")==null)
		return "user-login-signup";
		userService.addBloodInfo(req, BloodItem1);
		return "donatedBlood";
	}
	@RequestMapping(value="/deleteBlood")
	public String deleteBlood(HttpServletRequest req) throws ClassNotFoundException, SQLException
	{
	   userService.deleteBlood(req);
	   return "donatedBlood";
	}
	@RequestMapping(value="/search")
	public String search(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException, ClassNotFoundException, SQLException 
	{
	 userService.search(req);
	 return "search" ;
	}
	@RequestMapping(value="/user-login-signup")
	public String userloginsignup(HttpServletRequest req,HttpServletResponse res)
	{
	 return "user-login-signup" ;
	}
	@RequestMapping(value="/donatedBlood")
	public String userCart(HttpServletRequest req,HttpServletResponse res) throws ClassNotFoundException, SQLException
	{
	 userService.searchByEmail(req);
	 return "donatedBlood" ;
	}
	@RequestMapping(value="/addBlood")
	public String addBloodPage(HttpServletRequest req,HttpServletResponse res)
	{
	 return "addBlood" ;
	}
	@RequestMapping(value="/userIndex")
	public String userIndex(HttpServletRequest req,HttpServletResponse res) throws ClassNotFoundException, SQLException
	{
		userService.userIndex(req);
	 return "user-index" ;
	}
	
	
}
