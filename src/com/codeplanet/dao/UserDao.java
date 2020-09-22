package com.codeplanet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.codeplanet.model.BloodItem;
import com.codeplanet.model.User;

@Repository
public class UserDao {
 public boolean userSignup(User user) throws SQLException {
	    System.out.println("dao start");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BloodDonation","root","ashu1234");
    /*	PreparedStatement pst = con.prepareStatement("insert into sdetails values(?,?,?,?)");
    	pst.setString(1,user.getUserName());
    	pst.setString(2,user.getMobile());
    	pst.setString(3,user.getEmailId());
    	pst.setString(4,user.getPassword());
    	pst.executeUpdate();*/
		
		// For checking purpose that email already exists or not  !!
		String email = user.getUserEmail();
		email = email.toLowerCase();
		PreparedStatement pst1 = con.prepareStatement("select * from bloodDonation.users");
		ResultSet res = pst1.executeQuery();
		while(res.next())
		{
			if(email.equals(res.getString("email"))==true)
			return false;
		}
		pst1.close();
		res.close();
		
		pst1  =  con.prepareStatement("insert into users(email,password,name) value(?,?,?)");
		pst1.setString(1,user.getUserEmail().toLowerCase());
		pst1.setString(2,user.getUserPassword());
		pst1.setString(3,user.getUserName());
		pst1.executeUpdate();
		pst1.close();
    	System.out.println("dao end");
    	return true;
	}
public boolean userLogin(User user, HttpSession session) throws SQLException, ClassNotFoundException {
	String email = user.getUserEmail();
	email = email.toLowerCase();
	String password = user.getUserPassword();
	boolean temp=false;
	 try {
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BloodDonation","root","ashu1234");
	PreparedStatement pst = con.prepareStatement("select * from blooddonation.users");
	ResultSet res = pst.executeQuery();
	while(res.next())
	{   
		if(password.equals(res.getString("password"))==true&&email.equals(res.getString("email"))==true)
		{   temp = true;
		    session.setAttribute("userEmail",res.getString("email"));
		    session.setAttribute("userName",res.getString("name"));
			break;
		}
	}
	   }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 if(temp==true)
		 addAttributeForBloods(session);
	return temp;
}
         private void addAttributeForBloods(HttpSession session) throws SQLException, ClassNotFoundException {
        	 Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BloodDonation","root","ashu1234");
     		PreparedStatement statement1 = con.prepareStatement("select * from bloods inner join users on bloods.email=users.email ");
     		ResultSet res = statement1.executeQuery();
     		ArrayList<ArrayList<String>>search1 = setInArrayList(res);
     			session.setAttribute("bloods",search1);
     		}
		public void addBloodInfo(HttpServletRequest req,BloodItem bloodItem1) throws ClassNotFoundException, SQLException {
                Class.forName("com.mysql.jdbc.Driver");
            	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BloodDonation","root","ashu1234");
				PreparedStatement statement1 = con.prepareStatement("insert into bloods(bloodGroup,email,address,city,contact,name) values(?,?,?,?,?,?)");
				statement1.setString(1,bloodItem1.getGroup());
				statement1.setString(2, req.getSession().getAttribute("userEmail").toString());
				statement1.setString(3,bloodItem1.getAddress());
				statement1.setString(4,bloodItem1.getCity());
				statement1.setString(5,bloodItem1.getContact());
				statement1.setString(6,bloodItem1.getName());
			    statement1.execute();
			    searchByEmail(req);
			}
          
          public void deleteBlood(HttpServletRequest req) throws ClassNotFoundException, SQLException
          {
        	  Class.forName("com.mysql.jdbc.Driver");
        	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BloodDonation","root","ashu1234");
   				PreparedStatement statement1 = con.prepareStatement("DELETE FROM bloods WHERE bloodId=?");
   				statement1.setInt(1,Integer.parseInt(req.getParameter("BloodId").trim()));
   				statement1.execute();
   				searchByEmail(req);
          }
		public void search(HttpServletRequest req) throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BloodDonation","root","ashu1234");
		PreparedStatement statement1 = con.prepareStatement("select * from bloods inner join users on bloods.email=users.email where bloods.city = ? ");
		statement1.setString(1, req.getParameter("searchCity"));
		ResultSet res = statement1.executeQuery();
		ArrayList<ArrayList<String>>search1  =  setInArrayList(res);
			req.getSession().setAttribute("searchCity",search1);
		}
		public void searchByEmail(HttpServletRequest req) throws SQLException, ClassNotFoundException {
			 Class.forName("com.mysql.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BloodDonation","root","ashu1234");
				PreparedStatement statement1 = con.prepareStatement("select * from bloods inner join users on bloods.email=users.email where bloods.email = ? ");
				statement1.setString(1, (String) req.getSession().getAttribute("userEmail"));
				ResultSet res = statement1.executeQuery();
				ArrayList<ArrayList<String>>search1  =  setInArrayList(res);
					req.getSession().setAttribute("searchEmail",search1);
		}	
		private ArrayList<ArrayList<String>> setInArrayList(ResultSet res) throws SQLException
		{
			ArrayList<ArrayList<String>>search1 = new ArrayList<ArrayList<String>>();
			while(res.next())
			{
				ArrayList<String>search2 = new ArrayList<String>();

				    search2.add(Integer.toString(res.getInt("bloodId")));
				    search2.add(res.getString("bloods.name"));
				    search2.add(res.getString("email"));
				    search2.add(res.getString("city"));
				    search2.add(res.getString("bloodgroup"));
				    search2.add(res.getString("address"));
				    search2.add(res.getString("contact"));
				    
				   search1.add(search2);
			}
			return search1;
		}
		public void userIndex(HttpServletRequest req) throws ClassNotFoundException, SQLException {
			addAttributeForBloods(req.getSession());
			
		}
}