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

import com.trip.domain.Place;

import Factory.DaoFactory;

/**
 * Servlet implementation class CityGetImageSerclet
 */
@WebServlet("/citygetimage")
public class CityGetImageSerclet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CityGetImageSerclet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String city = request.getParameter("city");
		System.out.println(city);
		ArrayList<Place> ap = null;
		try {
			ap = DaoFactory.getPlaceDaoInstance().queryByCity(city);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		for (Iterator<Place> iterator = ap.iterator(); iterator.hasNext();) {
			Place place = (Place) iterator.next();
			sb.append(place.getImgPattern());
			sb.append("er");
			sb.append(place.getPlace());
			if (iterator.hasNext()) {
				sb.append("qwert");
			}
		}
		System.out.println(sb.toString());
		response.getWriter().write(sb.toString());
	}

}
