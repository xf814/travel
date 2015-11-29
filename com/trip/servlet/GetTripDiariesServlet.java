package com.trip.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import Factory.DaoFactory;

import com.trip.domain.Circle;
import com.trip.domain.Travel;
import com.trip.services.TravelDao;

/**
 * Servlet implementation class GetTripDiariesServlet
 */
@WebServlet("/GetCircle")
public class GetTripDiariesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetTripDiariesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Circle> circle=null;
		ArrayList<String>  images=null;
		StringBuilder sb=new StringBuilder();
		int userId=0;
		 try {
			  
			 circle=DaoFactory.getCircleDaoInstance().query();
			 sb.append(circle.size());
			 sb.append("ww");
			 for (Iterator iterator = circle.iterator(); iterator.hasNext();) {
				Circle circle2 = (Circle) iterator.next();
				sb.append(circle2.toString());
				String userName=DaoFactory.getUserDaoInstance().findName(circle2.getUserId());
				sb.append(userName);
				 sb.append("aa");
				userId=DaoFactory.getCircleDaoInstance().queryUserId(circle2.getCircleId());
				 String userPhoto=DaoFactory.getUserDaoInstance().findPhoto(userId);
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
			 System.out.println("here?"+sb.toString());
			 response.getOutputStream().write(sb.toString().getBytes("UTF-8"));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		   
	}

}
