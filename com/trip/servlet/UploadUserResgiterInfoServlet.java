package com.trip.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.DaoFactory;

import com.trip.domain.User;


@WebServlet("/UploadUserResgiterInfoServlet")
public class UploadUserResgiterInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadUserResgiterInfoServlet() {
		super();
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

		//处理乱码问题
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 得到客户端发送过来的用户昵称
		String nickname = request.getParameter("userNickname");
        System.out.println(nickname);
		// 得到客户端发送过来的用户登录邮箱
		String e_mail = request.getParameter("userEmail");

		// 得到客户端发送过来的用户登录密码
		String resgiter_password = request.getParameter("userPassword");
		System.out.println("66666");
		// 封装数据
		User user=new User(resgiter_password,e_mail,nickname,new Date(System.currentTimeMillis()));
		 int rs=-1;
		// 调用方法向数据库插入数据
		try {
			 rs=DaoFactory.getUserDaoInstance().insert(user);
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			
		}
		if(rs!=-1){
			response.getOutputStream().write("success".getBytes("UTF-8"));
		}else{
		response.getOutputStream().write("failure".getBytes("UTF-8"));
	}
	}

}
