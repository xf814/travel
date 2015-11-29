package com.trip.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.DaoFactory;

import com.trip.domain.Attention;

/**
 * Servlet implementation class QueryTagServlet
 */
@WebServlet("/queryTag")
public class QueryTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTagServlet() {
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
        System.out.print("===========进入QueryTagServlet==============");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String followName = request.getParameter("userName1");
		String followedName = request.getParameter("userName2");
		System.out.println("followName:" + followName);
		System.out.println("followedName:" + followedName);
		String tag;
		int follow_id;
		int followed_id;
		try {
			follow_id=DaoFactory.getUserDaoInstance().findId(followName);
			followed_id=DaoFactory.getUserDaoInstance().findId(followedName);
			tag = DaoFactory.getAttentionDaoIntance().queryTag(follow_id, followed_id);
			System.out.println("QueryTagServlet取到的tag--------------"+tag);
			response.getWriter().write(tag);
		} catch (SQLException e) {
			System.out.println("SQLException");
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
