package com.trip.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.DaoFactory;

/**
 * Servlet implementation class changetag
 */
@WebServlet("/changeTag")
public class Changetag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Changetag() {
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
		String userName = request.getParameter("followName");
		String personName =request.getParameter("followedName");
		int followId=0;
		int followedId=0;
		OutputStream os=response.getOutputStream();
		try {
			followId=DaoFactory.getUserDaoInstance().findId(userName);
			followedId=DaoFactory.getUserDaoInstance().findId(personName);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		try {
			int rs=DaoFactory.getAttentionDaoIntance().addAttention(followId, followedId);
			if(rs!=-1){
				os.write("success".getBytes("UTF-8"));
				System.out.println("success");
			}
			else 
			{
				os.write("failure".getBytes("UTF-8"));
				System.out.println("failure");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
