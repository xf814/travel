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
		String str = " �ϲ��У���ƺ飬�ֳƺ�ǡ�Ӣ�۳ǣ��ǽ���ʡʡ�ᣬ��ȫʡ�����Ρ����á��Ļ����Ƽ��ͽ�ͨ���ģ��������γ���Ⱥ��Ҫ���У�۶������̬���������ĳ��У��й���Ҫ���ۺϽ�ͨ��Ŧ���ִ�����ҵ���ء��ϲ��ش�����ʡ�в�ƫ�����ӽ����������Σ������й���һ��ˮ��۶�������ϰ����Թž��С�������ͥ����ͷ��β��֮�ơ��ϲ��ǹ�����ʷ�Ļ����ǣ�������ǧ���ٶ���Ľ���ʷ�����Ϸ����ٲ�ʢ��������һֱ���Ǹ����ݡ�ʡ����������1927���һ���壬�ڴ��ﵮ�����й�������";
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
