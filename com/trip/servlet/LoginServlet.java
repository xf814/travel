package com.trip.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.DaoFactory;

import com.trip.domain.User;
import com.trip.logic.CheckLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final  long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// ������������
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String nickname = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("......");
		System.out.println("LoginServlet�н��յ���username:"+nickname);
		System.out.println("LoginServlet�н��յ���password:"+password);
		User u = new User();
		u.setUserNickname(nickname);
		u.setUserPassword(password);
		
		// ������ɹ��ͷ��ؿͻ���success
		try {
			if (DaoFactory.getUserDaoInstance().login(nickname, password)) {
				System.out.println("success");
				response.getOutputStream().write(u.toString().getBytes("UTF-8"));// byte[]
			} else {
				response.getOutputStream().write("failure".getBytes("UTF-8"));
				System.out.println("failure");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(nickname + "oooooooooooo"+password);
	}

}
