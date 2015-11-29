package com.trip.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.DaoFactory;

import com.trip.domain.Order;
import com.trip.utils.UUIDTools;

/**
 * Servlet implementation class HotelServlet
 */
@WebServlet("/HotelServlet")
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelServlet() {
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
		String userName = null;
		String title = null;
		String tel = null;
		String date = null;
		int selectDay =0;
		String selectRoom=null;
		int selectCount = 0;
	    userName = request.getParameter("userName");
	    title  = request.getParameter("title ");
	    tel = request.getParameter("tel");
	    date = request.getParameter("date");
	    selectDay = Integer.valueOf(request.getParameter("selectDay"));
	    selectRoom =request.getParameter("selectRoom");
	    selectCount = Integer.valueOf(request.getParameter("selectCount"));
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date d = null;
	    try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			System.out.println("格式错误");
			e.printStackTrace();
		}
	    int money =260*selectDay*selectCount;
	    Order order = new Order(new Random().nextInt(),money,selectRoom,d,selectDay,10000000);
	    try {
			DaoFactory.getOrderDaoInstance().insert(order);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	    request.getSession().setAttribute("orderId", UUIDTools.getUUID() );
	    request.setAttribute("goods", "住宿费");
	    request.setAttribute("money", money);
	    request.setAttribute("count", selectCount);
	    request.setAttribute("danjia", 260);
	    request.setAttribute("room", selectRoom);
	    
	    request.getRequestDispatcher("/pay.jsp").forward(request, response);
	}

}
