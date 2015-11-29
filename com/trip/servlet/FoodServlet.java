package com.trip.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.trip.domain.Food;

import Factory.DaoFactory;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet("/food")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
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
		System.out.println("-----------------------food servlet--------------");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String cityName=new String(request.getParameter("cityName").getBytes("iso-8859-1"), "utf-8");
		
		ArrayList<Food>  af=DaoFactory.getFoodDaoInstance().queryByName(cityName);
		
		request.setAttribute("ArrayListFood", af);
		request.getRequestDispatcher("/food.jsp").forward(request, response);
		
	}

}
