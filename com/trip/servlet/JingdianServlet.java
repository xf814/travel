package com.trip.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trip.domain.Place;

import Factory.DaoFactory;

/**
 * Servlet implementation class JingdianServlet
 */
@WebServlet("/jingdian")
public class JingdianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JingdianServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
	String  city = new String(request.getParameter("cityName").getBytes("ISO-8859-1"), "UTF-8") ;
	//String city =request.getParameter("city");
		System.out.println(request.getParameter("cityName"));
		System.out.println(city);
		ArrayList<Place> ap =null;
		try {
			 ap=DaoFactory.getPlaceDaoInstance().queryByCity(city);
			 System.out.println(ap);
			 System.out.println(ap==null);
				request.getSession().setAttribute("ArrayListPlace", ap);
			    
				request.getRequestDispatcher("/jingdian.jsp").forward(request, response);
				
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
