package com.trip.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.DaoFactory;

import com.trip.domain.User;

/**
 * Servlet implementation class QueryFriendInfoServlet
 */
@WebServlet("/queryFriendInfo")
public class QueryFriendInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryFriendInfoServlet() {
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
        System.out.print("===========进入QueryFriendInfoServlet==============");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String authorName = request.getParameter("userName");
		System.out.println("userName:" + authorName);
		String info;
		int userId;
		try {
			userId=DaoFactory.getUserDaoInstance().findId(authorName);
			info = DaoFactory.getUserDaoInstance().queryUserInfo(userId);
			System.out.println("QueryFriendInfoServlet--info:");
			System.out.println(info);
			response.getWriter().write(info);
		} catch (SQLException e) {
			System.out.println("SQLException");
			// TODO 自动生成的 catch 块
			e.printStackTrace();

		}
	
		
	}

}
