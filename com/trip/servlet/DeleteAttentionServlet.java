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
import com.trip.domain.Circle;

/**
 * Servlet implementation class DeleteAttentionServlet
 */
@WebServlet("/deleteAttention")
public class DeleteAttentionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAttentionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		String attention_id=request.getParameter("attention_id");
		String name=request.getParameter("userName");
		ArrayList<Attention> ap = new ArrayList<Attention>();
		StringBuilder sb = new StringBuilder();
		int userId;
		
		System.out.println("===============DeleteAttentionServlet===================");
		System.out.println("DeleteAttentionServlet中接收到的attention_id:"+attention_id);
		System.out.println("DeleteAttentionServlet中接收到的userName:"+name);
		int attentionId=Integer.parseInt(attention_id);
		
		try {
			DaoFactory.getAttentionDaoIntance().deleteAttention(attentionId);
			System.out.println("取消关注方法已执行");
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
