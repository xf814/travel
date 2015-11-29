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

import com.trip.domain.Plan;

import Factory.DaoFactory;

/**
 * Servlet implementation class DeletePlanServlet
 */
@WebServlet("/deleteplan")
public class DeletePlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlanServlet() {
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
		String planId=request.getParameter("planId");
		String authorName=request.getParameter("userName");
		ArrayList<Plan>  ap=new ArrayList<Plan>();
		StringBuilder sb=new StringBuilder();
		System.out.println("进入DeletePlanServlet");
		System.out.println("PlanServlet中接收到的planId:"+planId);
		int plan_id=Integer.parseInt(planId);
		int a=0;
		try {
			a=DaoFactory.getPlanDaoInstance().deleteByPlanId(plan_id);
			System.out.println("servlet计划删除成功");

			ap=DaoFactory.getPlanDaoInstance().queryByName(authorName);//通过authorName查询计划
			//System.out.println("3333"+ap);
			sb.append(ap.size());//计划的条数
			sb.append("qq");
			for (Iterator iterator = ap.iterator(); iterator.hasNext();) {
				Plan plan1 = (Plan) iterator.next();
				sb.append("mmm");
				sb.append(plan1.toString());
				if(iterator.hasNext()){
					sb.append("qwert");
				}
			}
			System.out.println(sb.toString());
			response.getWriter().write(sb.toString());
		
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
