package com.trip.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trip.domain.Place;
import com.trip.domain.Plan;

import Factory.DaoFactory;

/**
 * Servlet implementation class SetPlan
 */
@WebServlet("/setPlan")
public class SetPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPlanServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String city = request.getParameter("city");
		String place =request.getParameter("place");
		String str1=request.getParameter("planTime");
		String userName=request.getParameter("userName");
//		String str2=request.getParameter("createTime");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd��");
		OutputStream os=response.getOutputStream();

		Date newTime=new Date();
        	
		
		Date d =null;
		try {
			d =sdf.parse(str1);
		
		} catch (ParseException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		System.out.println(city);
		System.out.println(place);
		Place p;
		String placeOpenTime=null;
		String placeImage=null;
		String placeAddress=null;
		try {
			p = DaoFactory.getPlaceDaoInstance().queryByPlace(place);
			placeOpenTime=p.getPlaceShiJian();
			placeImage=p.getImgPattern();
			placeAddress=p.getPlaceDiZhi();
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		Plan plan = new Plan();
//		=new Plan(userName,d, place, placeOpenTime, newTime, placeAddress, placeImage, city);
		plan.setAuthorName(userName);
		plan.setPlanTime(d);
		plan.setPlanPlace(place);
		plan.setPlanPlaceTime(placeOpenTime);
		plan.setPlanCreateTime(newTime);
		plan.setPlanPlaceAdd(placeAddress);
		plan.setPlanPlaceImg(placeImage);
		plan.setCity(city);
		
		try {
			int rs=DaoFactory.getPlanDaoInstance().insert(plan);
			if(rs!=-1){
//				os.write("success".getBytes("UTF-8"));
				System.out.println("success");
			}
			else 
			{
				os.write("failure".getBytes("UTF-8"));
				System.out.println("failure");
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		//�����ݿ��ж�ȡplan
		ArrayList<Plan>  ap=new ArrayList<Plan>();
		StringBuilder sb=new StringBuilder();
		try {
			ap=DaoFactory.getPlanDaoInstance().queryByName(userName);//ͨ��authorName��ѯ�ƻ�
			//System.out.println("3333"+ap);
			sb.append(ap.size());//�ƻ�������
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
			os.write(sb.toString().getBytes("UTF-8"));
		} catch (SQLException e) {
			System.out.println("23234");
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			
		}
		
		/*
		try {
			ap=DaoFactory.getPlanDaoInstance().queryByName(userName);
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		for (Iterator iterator = ap.iterator(); iterator.hasNext();) {
			Plan plan1 = (Plan) iterator.next();
			sb.append(plan.toString());
			if(iterator.hasNext()){
				sb.append("qwert");
			}
		}
		System.out.println("222"+sb.toString());
		os.write(sb.toString().getBytes("UTF-8"));*/
		//Sun May 17 00:00:00 CST 2015qwert������qwert������5��1��-10��7�գ�7:30-18:00��������10��8��-����4��30�գ�8:00-17:30�� qwert2015��05��10�� 06:54:26qwert�ϲ��ж������¹Ž�58��qwertimg/nanchang1.jpgqwertqwert
		//Sun May 17 00:00:00 CST 2015qwert������qwert������5��1��-10��7�գ�7:30-18:00��������10��8��-����4��30�գ�8:00-17:30�� qwert2015��05��10�� 06:54:26qwert�ϲ��ж������¹Ž�58��qwertimg/nanchang1.jpgqwert�Ϻ�
		//qwertSun May 17 00:00:00 CST 2015qwert������qwert������5��1��-10��7�գ�7:30-18:00��������10��8��-����4��30�գ�8:00-17:30�� qwert2015��05��10�� 06:54:26qwert�ϲ��ж������¹Ž�58��qwertimg/nanchang1.jpgqwert�Ϻ�
		//qwertSun May 17 00:00:00 CST 2015qwert������qwert������5��1��-10��7�գ�7:30-18:00��������10��8��-����4��30�գ�8:00-17:30�� qwert2015��05��10�� 06:54:26qwert�ϲ��ж������¹Ž�58��qwertimg/nanchang1.jpgqwert�Ϻ�
		//qwertSun May 17 00:00:00 CST 2015qwert������qwert������5��1��-10��7�գ�7:30-18:00��������10��8��-����4��30�գ�8:00-17:30�� qwert2015��05��10�� 06:54:26qwert�ϲ��ж������¹Ž�58��qwertimg/nanchang1.jpgqwert�Ϻ�
		//qwertSun May 17 00:00:00 CST 2015qwert������qwert������5��1��-10��7�գ�7:30-18:00��������10��8��-����4��30�գ�8:00-17:30�� qwert2015��05��10�� 06:54:26qwert�ϲ��ж������¹Ž�58��qwertimg/nanchang1.jpgqwert�Ϻ�
		//qwertSun May 17 00:00:00 CST 2015qwert������qwert������5��1��-10��7�գ�7:30-18:00��������10��8��-����4��30�գ�8:00-17:30�� qwert2015��05��10�� 06:54:26qwert�ϲ��ж������¹Ž�58��qwertimg/nanchang1.jpgqwert�Ϻ�
	}

}
