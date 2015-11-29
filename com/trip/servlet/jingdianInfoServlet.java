package com.trip.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.DaoFactory;

import com.trip.domain.Place;

/**
 * Servlet implementation class jingdianInfoServlet
 */
@WebServlet("/jingdianInfo")
public class jingdianInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jingdianInfoServlet() {
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

		System.out.println("进入--------------------------jingdianInfoServlet");
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
	    String jingdianName = new String(request.getParameter("jingdian").getBytes("ISO-8859-1"), "UTF-8") ;
//	    System.out.println("servlet请求----------"+jingdianName);
		Place place=new Place();
		try {
			place=DaoFactory.getPlaceDaoInstance().queryByPlace(jingdianName);
//			System.out.println("servlet结果-----------"+place.getPlace());
				request.getSession().setAttribute("place", place);
				request.getRequestDispatcher("/jingdianinfo.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	
	}

}
