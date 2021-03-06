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

import com.trip.domain.Circle;

/**
 * Servlet implementation class QueryAllFansServlet
 */
@WebServlet("/queryAllFans")
public class QueryAllFansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllFansServlet() {
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
		String userName=request.getParameter("userName");
		System.out.println("1234");
		int followedId=0;
		ArrayList al=new ArrayList();
		ArrayList<Circle> circle=null;
		ArrayList<String>  images=null;
		StringBuilder sb=new StringBuilder();
		try {
			followedId=DaoFactory.getUserDaoInstance().findId(userName);
			al=DaoFactory.getAttentionDaoIntance().queryFollowId(followedId);
			sb.append(al.size());
			sb.append("count");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Iterator iterator = al.iterator(); iterator.hasNext();) {
			Integer followId = (Integer) iterator.next();
			
			circle=new ArrayList<Circle>();
			try {
				circle=DaoFactory.getCircleDaoInstance().queryByUserId(followId);
				System.out.println("11111111"+circle);
				sb.append(circle.size());
				 sb.append("ww");
				 for (Iterator iterator1 = circle.iterator(); iterator1.hasNext();) {
					Circle circle2 = (Circle) iterator1.next();
					sb.append(circle2.toString());
					 String followName=DaoFactory.getUserDaoInstance().findName(followId);
					
					 sb.append(followName);
					 sb.append("aa");
					 String userPhoto=DaoFactory.getUserDaoInstance().findPhoto(followId);
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
					if(iterator1.hasNext()){
						sb.append("qwert");
					}
				 }
				 if(iterator.hasNext()){
				 sb.append("pp");
				 }
			}
				
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
		}
		System.out.println(sb.toString());
		response.getOutputStream().write(sb.toString().getBytes("UTF-8"));
	}
}