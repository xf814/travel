package com.trip.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travel.pay.PaymentUtil;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderId = (String) request.getSession().getAttribute("orderId");
		// String goodsname = request.getParameter("goodsname");
		String bank = "CCB-NET-B2C";
		String account = "10001126856";
		String money = "0.01";
		String Cur = "CNY";
		String way = "Buy";
		String url = "localhost:8080/Travel//PayBackServlet";
		String key = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		String hmac = PaymentUtil.buildHmac(way, account, orderId, money, Cur,
				"", "", "", url, "0", "", bank, "1", key);
		response.sendRedirect("https://www.yeepay.com/app-merchant-proxy/node?p0_Cmd="+way+"&p1_MerId="+account+"&p2_Order="+orderId+"&p3_Amt="+money+"&p4_Cur="+Cur+"&p5_Pid=&p6_Pcat=&p7_Pdesc=&p8_Url="
				+url+"&p9_SAF=0&pa_MP=&pd_FrpId="+bank+"&pr_NeedResponse=1&hmac="+hmac);
	}

}
