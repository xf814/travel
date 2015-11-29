package com.trip.servlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import Factory.DaoFactory;

import com.trip.domain.Circle;
import com.trip.domain.Comment;
import com.trip.services.TravelDao;

/**
 * Servlet implementation class SendTripDiariesServlet
 */
@WebServlet("/SendTripDiariesServlet")
public class SendTripDiariesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendTripDiariesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Circle c=null;
		ArrayList<Circle> circle=null;
		ArrayList<String>  images=null;
		StringBuilder sb=new StringBuilder();
		// response.getOutputStream().write("�����μǳɹ���".getBytes("UTF-8"));

		HashMap<String, String> map = new HashMap<>();

		// String filepath = null; //ͼƬ�ڴ����ϵľ��Ե�ַ

		String filePath = null; // ͼƬ����Ե�ַ
		int count=0;
		int userId=0;
		// �ж��Ƿ�Ϊ���ļ�������
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		// ����ϴ����������ļ����;�ִ�����´���
		if (isMultipart) {

			String realpath = request.getSession().getServletContext()
					.getRealPath("/img");
			String anotherpath = "F://Java/workspace/Travel/WebContent/img";
			System.out.println(realpath);

			File file = new File(realpath);
			File fileanother = new File(anotherpath);
			if (!file.exists()) {
				file.mkdirs();
			}

			try {
				FileItemFactory factory = new DiskFileItemFactory();

				ServletFileUpload upload = new ServletFileUpload(factory);

				upload.setHeaderEncoding("UTF-8");

				List<FileItem> items = upload.parseRequest(request);

				for (FileItem item : items) {

					// ����ϴ������Ĳ����ļ���ִ�����´���
					if (item.isFormField()) {

						String name = item.getFieldName();

						map.put(name, item.getString("UTF-8"));

					} else {
						String filename = System.currentTimeMillis()
								+ item.getName().substring(
										item.getName().lastIndexOf("."));
						File f = new File(file, filename);
						item.write(f);
						FileUtils.copyFile(f, new File(anotherpath, filename));
						// request.getScheme();
						// ���ص�Э������,Ĭ����http
						//
						// request.getServerName()
						// ���ص��������������ʾ��������
						//
						// getServerPort()
						// ��ȡ�������˿ں�

						// ��װͼƬ�ڷ������ϵ�·��
						filePath ="img" + "/"
								+ filename;
						System.out.println(filePath);

						// filepath = realpath + "\\"+ filename;
						String content = map.get("diariesBody");
						String date = map.get("date");
						String time=map.get("time");
						String userName=map.get("userName");
				
						
						try {
							userId=DaoFactory.getUserDaoInstance().findId(userName);
						} catch (SQLException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
						
				        try {
				        	System.out.println(count);
				        	if(count==0){
				        	   c=new Circle();
				        		c.setUserId(userId);
				        		c.setCircleContent(content);
				        		c.setCircleDate(date);
				        		c.setCircleTime(time);
							DaoFactory.getCircleDaoInstance().insert(c);
				        	count++;
				        	}
							DaoFactory.getCircleDaoInstance().findIdInsertImages(time, filePath);
							
						} catch (SQLException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	        
		}
		// ��������͵��μ�ʱ���ı���ʽ��
		else {
			request.setCharacterEncoding("UTF-8");

			String content = request.getParameter("diariesBody");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String userName=request.getParameter("userName");
		
			try {
				userId=DaoFactory.getUserDaoInstance().findId(userName);
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			 c=new Circle();
     		c.setUserId(userId);
     		c.setCircleContent(content);
     		c.setCircleDate(date);
     		c.setCircleTime(time);
			try {
				DaoFactory.getCircleDaoInstance().insert(c);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
		}
		
	    
	   try {
		  
		 circle=DaoFactory.getCircleDaoInstance().query();
		 sb.append(circle.size());
		 sb.append("ww");
		 for (Iterator iterator = circle.iterator(); iterator.hasNext();) {
			Circle circle2 = (Circle) iterator.next();
			sb.append(circle2.toString());
			String userName=DaoFactory.getUserDaoInstance().findName(circle2.getUserId());
			sb.append(userName);
			 sb.append("aa");
			userId=DaoFactory.getCircleDaoInstance().queryUserId(circle2.getCircleId());
			 String userPhoto=DaoFactory.getUserDaoInstance().findPhoto(userId);
			 sb.append(userPhoto);
			
			images=DaoFactory.getImagesDaoInstance().query(circle2.getCircleId());
			sb.append("yy");
			sb.append(images.size());
			sb.append("er");
			for (Iterator iterator2 = images.iterator(); iterator2.hasNext();) {
				String images2 = (String) iterator2.next();
				   sb.append(images2);
				   if(iterator2.hasNext()){
				   sb.append("tt");
				   }
			}
			if(iterator.hasNext()){
				sb.append("qwert");
			}
			
			
		}
		 System.out.println(sb.toString());
		 response.getOutputStream().write(sb.toString().getBytes("UTF-8"));
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
	   
	   
	 /*  2ww
	   80000008Nnnnnnnnnnnnnnnn2015-5-1712:15:010img/apple.jpg
	   2er
	   img/1431836094277.png
	   tt
	   img/1431836094319.png
	   qwert
	   80000009ͻȻ�о���2015-5-1712:18:420img/apple.jpg
	   3erimg/1431836318332.png
	   tt
	   img/1431836318389.png
	   tt
	   img/1431836318417.png*/
	}

}
