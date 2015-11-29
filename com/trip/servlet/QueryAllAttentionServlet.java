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
 * Servlet implementation class QueryAllAttention
 */
@WebServlet("/queryall")
public class QueryAllAttentionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public QueryAllAttentionServlet() {
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
		int followId=0;
		ArrayList al=new ArrayList();
		ArrayList<Circle> circle=null;
		ArrayList<String>  images=null;
		StringBuilder sb=new StringBuilder();
		try {
			followId=DaoFactory.getUserDaoInstance().findId(userName);
			al=DaoFactory.getAttentionDaoIntance().queryFollowedId(followId);
			sb.append(al.size());
			sb.append("count");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Iterator iterator = al.iterator(); iterator.hasNext();) {
			Integer followedId = (Integer) iterator.next();
			
			circle=new ArrayList<Circle>();
			try {
				circle=DaoFactory.getCircleDaoInstance().queryByUserId(followedId);
				sb.append(circle.size());
				 sb.append("ww");
				 for (Iterator iterator1 = circle.iterator(); iterator1.hasNext();) {
					Circle circle2 = (Circle) iterator1.next();
					sb.append(circle2.toString());
					 String followedName=DaoFactory.getUserDaoInstance().findName(followedId);
					
					 sb.append(followedName);
					 sb.append("aa");
					 String userPhoto=DaoFactory.getUserDaoInstance().findPhoto(followedId);
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



