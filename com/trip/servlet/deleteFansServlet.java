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

import com.trip.domain.Circle;

/**
 * Servlet implementation class deleteFansServlet
 */
@WebServlet("/deleteFans")
public class deleteFansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteFansServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String follow_name=request.getParameter("followName");
		String followed_name=request.getParameter("followedName");
		System.out.println("follow_name"+follow_name);
		System.out.println("followed_name"+followed_name);
		StringBuilder sb=new StringBuilder();
		int follow_id=0;
		int followed_id=0;
		try {
			follow_id=DaoFactory.getUserDaoInstance().findId(follow_name);
			followed_id=DaoFactory.getUserDaoInstance().findId(followed_name);
			int re=DaoFactory.getAttentionDaoIntance().deleteAttention(follow_id, followed_id);
			System.out.println(re);
			System.out.println("servlet删除说说方法已执行");
		    
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
