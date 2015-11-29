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

import com.trip.domain.Attention;

/**
 * Servlet implementation class QueryAttentionsServlet
 */
@WebServlet("/queryFans")
public class QueryFansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
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
		String authorName = request.getParameter("userName");
		ArrayList<Attention> ap = new ArrayList<Attention>();
		StringBuilder sb = new StringBuilder();
		int userId;
		try {
			userId=DaoFactory.getUserDaoInstance().findId(authorName);
			ap = DaoFactory.getAttentionDaoIntance().queryFanByUserId(userId);
			System.out.println(ap);
			sb.append(ap.size());
			sb.append("qq");
			for (Iterator iterator = ap.iterator(); iterator.hasNext();) {
				Attention Attention1 = (Attention) iterator.next();
				sb.append("mmm");
				sb.append(Attention1.toString());
				String userName1=DaoFactory.getUserDaoInstance().findName(Attention1.getFollowId());
				String userName2=DaoFactory.getUserDaoInstance().findName(Attention1.getFollowedId());
				String AttentionIntro=DaoFactory.getUserDaoInstance().findIntro(Attention1.getFollowId());
				String folowPhoto=DaoFactory.getUserDaoInstance().findPhoto(Attention1.getFollowId());
				sb.append("qwert");
				sb.append(userName1);
				sb.append("qwert");
				sb.append(userName2);
				sb.append("qwert");
				sb.append(AttentionIntro);
				sb.append("qwert");
				sb.append(folowPhoto);
				
				if (iterator.hasNext()) {
					sb.append("qwert");
				}
			}
			System.out.println("QueryFansServlet返回结果------------"+sb.toString());
			response.getWriter().write(sb.toString());
		} catch (SQLException e) {
			System.out.println("SQLException");
			// TODO 自动生成的 catch 块
			e.printStackTrace();

		}
	}

}
