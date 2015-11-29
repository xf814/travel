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
import com.trip.domain.Plan;

/**
 * Servlet implementation class DeletecircleServlet
 */
@WebServlet("/deleteCircle")
public class DeleteCircleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCircleServlet() {
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
		String circle_Id=request.getParameter("circleId");
		String name=request.getParameter("userName");
		ArrayList<Circle> circle=null;
		ArrayList<String>  images=null;
		StringBuilder sb=new StringBuilder();
		int id=0;
		System.out.println("进入DeleteCircleServlet");
		System.out.println("DeleteCircleServlet中接收到的circleId:"+circle_Id);
		System.out.println("DeleteCircleServlet中接收到的userName:"+name);
		int circleId=Integer.parseInt(circle_Id);
		
		try {
			DaoFactory.getCircleDaoInstance().deleteCircle(circleId);
			System.out.println("servlet删除说说方法已执行");
		    
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		try {
			id=DaoFactory.getUserDaoInstance().findId(name);
			System.out.print("==============="+id);
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
		
	}

}
