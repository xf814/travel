package com.trip.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GonglueServlet
 */
@WebServlet("/GonglueServlet")
public class GonglueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GonglueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		String str = " 南昌市，简称洪，又称洪城、英雄城，是江西省省会，是全省的政治、经济、文化、科技和交通中心，长江中游城市群重要城市，鄱阳湖生态经济区核心城市，中国重要的综合交通枢纽和现代制造业基地。南昌地处江西省中部偏北，赣江、抚河下游，濒临中国第一大淡水湖鄱阳湖西南岸，自古就有“粤户闽庭，吴头楚尾”之称。南昌是国家历史文化名城，有着两千两百多年的建城史，因南方繁荣昌盛而得名，一直都是府、州、省、道治所，1927年八一起义，在此里诞生了中国共产党";
		System.out.println(str.length());
		OutputStream os = response.getOutputStream();
		os.write(str.getBytes("UTF-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
