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

import com.trip.domain.User;

/**
 * Servlet implementation class FindFriendsServlet
 */
@WebServlet("/findFriends")
public class FindFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindFriendsServlet() {
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
		System.out.println("==============findFriendsServlet========");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userName=request.getParameter("userName");
		ArrayList<User> ap = new ArrayList<User>();
		StringBuilder sb = new StringBuilder();
		
		int userId;
		try {
			userId=DaoFactory.getUserDaoInstance().findId(userName);
			ap = DaoFactory.getUserDaoInstance().queryFriend(userId);
		
			sb.append(ap.size());// 个数
			sb.append("qq");
			for (Iterator iterator = ap.iterator(); iterator.hasNext();) {
				User User1 = (User) iterator.next();
				sb.append(User1.toString3());
				
				if (iterator.hasNext()) {
					sb.append("qwert");
				}
			}
			System.out.println("findFriendsServlet返回结果------------");
			System.out.println(sb.toString());
			response.getWriter().write(sb.toString());
		} catch (SQLException e) {
			System.out.println("SQLException");
			// TODO 自动生成的 catch 块
			e.printStackTrace();
}
	}

}
