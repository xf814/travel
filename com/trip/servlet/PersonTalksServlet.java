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

import com.trip.domain.Circle;

import Factory.DaoFactory;

/**
 * Servlet implementation class PersonTalksServlet
 */
@WebServlet("/persontalks")
public class PersonTalksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonTalksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name=request.getParameter("userName");
		ArrayList<Circle> circle=null;
		ArrayList<String>  images=null;
		StringBuilder sb=new StringBuilder();
		int id=0;
		try {
			id=DaoFactory.getUserDaoInstance().findId(name);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			circle=new ArrayList<Circle>();
			circle=DaoFactory.getCircleDaoInstance().queryByUserId(id);
			 sb.append(circle.size());
			 sb.append("ww");
			 for (Iterator iterator = circle.iterator(); iterator.hasNext();) {
				Circle circle2 = (Circle) iterator.next();
				sb.append(circle2.toString());
				 String userName=DaoFactory.getUserDaoInstance().findName(id);
				
				 sb.append(userName);
				 sb.append("aa");
				 String userPhoto=DaoFactory.getUserDaoInstance().findPhoto(id);
				 sb.append(userPhoto);
				
				images=DaoFactory.getImagesDaoInstance().query(circle2.getCircleId());
				sb.append("yy");
				sb.append(images.size());
				sb.append("er");
				for (Iterator iterator2 = images.iterator(); iterator2.hasNext();) {
					String images2 = (String) iterator2.next();
					   sb.append(images2);
					   if(iterator2.hasNext()){
					   sb.append("tt");
					   }
				}
				if(iterator.hasNext()){
					sb.append("qwert");
				}
			 }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(sb.toString());
		 response.getOutputStream().write(sb.toString().getBytes("UTF-8"));
		
		 /*2ww
		 70000014aa10000003aaNbbbbhjbhhhhhhhaa2015-5-17aa16:00:23aa0aaimg/apple.jpg
		 yy
		 2er
		 img/1431849616850.png
		 tt
		 img/1431849616900.png
		 qwert
		 70000015aa10000003aaOK了啦瑞金aa2015-5-17aa16:47:40aa0aaimg/apple.jpg
		 yy
		 2er
		 img/1431852453706.png
		 tt
		 img/1431852453782.png*/
	}

}
