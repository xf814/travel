package com.trip.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trip.domain.User;

import Factory.DaoFactory;

/**
 * Servlet implementation class ChangeUserInfoServlet
 */
@WebServlet("/changeUserInfo")
public class ChangeUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String user_nickname=request.getParameter("user_nickname").trim();
		String user_realname=request.getParameter("user_realname").trim();
		String user_sex=request.getParameter("user_sex").trim();
		String user_birthday=request.getParameter("user_birthday").trim();
		String user_tele=request.getParameter("user_tele").trim();
		String user_email=request.getParameter("user_email").trim();
		String user_intro=request.getParameter("user_intro").trim();
		String user_location=request.getParameter("user_location").trim();
		User u=new User(user_nickname,user_realname,user_sex,user_birthday,user_tele,user_email,user_intro,user_location);
	
		int id=0;
		try {
			 id=DaoFactory.getUserDaoInstance().findId(user_nickname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DaoFactory.getUserDaoInstance().update(u, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
