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

		//������������
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// �õ��ͻ��˷��͹������û��ǳ�
		String nickname = request.getParameter("userNickname");
        System.out.println(nickname);
		// �õ��ͻ��˷��͹������û���¼����
		String e_mail = request.getParameter("userEmail");

		// �õ��ͻ��˷��͹������û���¼����
		String resgiter_password = request.getParameter("userPassword");
		System.out.println("66666");
		// ��װ����
		User user=new User(resgiter_password,e_mail,nickname,new Date(System.currentTimeMillis()));
		 int rs=-1;
		// ���÷��������ݿ��������
		try {
			 rs=DaoFactory.getUserDaoInstance().insert(user);
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			
		}
		if(rs!=-1){
			response.getOutputStream().write("success".getBytes("UTF-8"));
		}else{
		response.getOutputStream().write("failure".getBytes("UTF-8"));
	}
	}

}
