package com.codeplanet.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeplanet.dao.UserDao;
import com.codeplanet.model.BloodItem;
import com.codeplanet.model.User;

@Service
public class UserService {
@Autowired
UserDao userDao;

	public boolean userSignup(User user) throws SQLException {
		 System.out.println("service start");
		 System.out.println("service start");
		return userDao.userSignup(user);
		
	}
	public boolean userLogin(User user, HttpSession session) throws SQLException, ClassNotFoundException {
	    return userDao.userLogin(user,session);
	}
	public void addBloodInfo(HttpServletRequest req,BloodItem BloodItem1) throws ClassNotFoundException, SQLException {
		userDao.addBloodInfo(req, BloodItem1);
		// TODO Auto-generated method stub
		
	}
	public void deleteBlood(HttpServletRequest req) throws ClassNotFoundException, SQLException {
		userDao.deleteBlood(req);
		
	}
	public void search(HttpServletRequest req) throws ClassNotFoundException, SQLException {
		userDao.search(req);
	}
	public void searchByEmail(HttpServletRequest req) throws ClassNotFoundException, SQLException {
		userDao.searchByEmail(req);
	}
	public void userIndex(HttpServletRequest req) throws ClassNotFoundException, SQLException {
		userDao.userIndex(req);
		
	}
}
