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
 * Servlet implementation class AddAttentionsServlet2
 */
@WebServlet("/AddAttentions2")
public class AddAttentionsServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAttentionsServlet2() {
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
		String followed_name=request.getParameter("followed_name");
		String name=request.getParameter("userName");
		int userId;
		int followedId;
		
		try {
			userId=DaoFactory.getUserDaoInstance().findId(name);
			followedId=DaoFactory.getUserDaoInstance().findId(followed_name);
			
			if(DaoFactory.getAttentionDaoIntance().queryAttentionState(userId,followedId)=="f"){
				DaoFactory.getAttentionDaoIntance().addAttention(userId, followedId);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
