package com.trip.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trip.domain.City;
import com.trip.domain.Place;

import Factory.DaoFactory;

/**
 * Servlet implementation class PlaceServlet
 */
@WebServlet("/gaikuang")
public class GaikuangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GaikuangServlet() {
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
		response.setCharacterEncoding("utf-8");
	     City city = null;
		/*try {
			place = DaoFactory.getPlaceDaoInstance().queryById(21);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
		String cityName =new String(request.getParameter("cityName").getBytes("ISO-8859-1"), "UTF-8") ;
		System.out.println(cityName);
		try {
			city=DaoFactory.getCityDaoInstance().queryByCityName(cityName);
			request.getSession().setAttribute("city", city);
			request.getRequestDispatcher("/gaikuang.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		
	}

}
