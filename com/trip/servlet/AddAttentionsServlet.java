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
 * Servlet implementation class AddAttentionsServlet
 */
@WebServlet("/addAttentions")
public class AddAttentionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddAttentionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userId1=request.getParameter("user1_id");
		String userId2=request.getParameter("user2_id");
		String name=request.getParameter("userName");
		ArrayList<Attention> ap = new ArrayList<Attention>();
		StringBuilder sb = new StringBuilder();
		int userId;
		
		int user1Id=Integer.parseInt(userId1);
		int user2Id=Integer.parseInt(userId2);
		try {
			DaoFactory.getAttentionDaoIntance().addAttention(user1Id, user2Id);
			System.out.println("关注方法已执行");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		try {
			userId=DaoFactory.getUserDaoInstance().findId(name);
			ap = DaoFactory.getAttentionDaoIntance().queryAttentionByUserId(userId);
			System.out.println(ap);
			sb.append(ap.size());
			sb.append("qq");
			for (Iterator iterator = ap.iterator(); iterator.hasNext();) {
				Attention Attention1 = (Attention) iterator.next();
				sb.append("mmm");
				sb.append(Attention1.toString());
				String followName=DaoFactory.getUserDaoInstance().findName(Attention1.getFollowId());
				String followedName=DaoFactory.getUserDaoInstance().findName(Attention1.getFollowedId());
				String followedIntro=DaoFactory.getUserDaoInstance().findIntro(Attention1.getFollowedId());
				
				sb.append("qwert");
				sb.append(followName);
				sb.append("qwert");
				sb.append(followedName);
				sb.append("qwert");
				sb.append(followedIntro);
				
				if (iterator.hasNext()) {
					sb.append("qwert");
				}
			}
			System.out.println(sb.toString());
			response.getWriter().write(sb.toString());
		} catch (SQLException e) {
			System.out.println("SQLException");
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
