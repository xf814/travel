package com.trip.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JiudianServlet
 */
@WebServlet("/jiudian")
public class JiudianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JiudianServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		String str="���������Ƶ��������Ͻ����߶���ߵ����Ǽ��Ƶ꣬��ҵ��1999��12�£��и߼��ͷ�202�䣬�������뺣����278�״����˹���Jumeirah Beach Resort�ϡ������ۺ������µĽ��������̿Ƽ������˵ľ��¼����ͣ�ʹ������ȥ�·�������Ϊһ�塣"
				+ "2005��2��22�����������һ����ʿѡ�ַѵ��պ����������Ͻ��������ڲμӵϰݹ�������϶�������ų�����������ľƵ꣬λ�ڵϰݺ���ġ��������������궥�˵�һ����һ�޶��Ŀ������򳡽���һ������������������ݳƴ�����ԭ��ֱ����ͣ��ƺ���������200���ף������ľ������������������������н��еķ�������ľƵ꽨�ں�����һ���˹����ϣ���һ�������ε���״�������������뺣����280�״����˹���Jumeirah Beach Resort�ϡ� ����˫��Ĥ�ṹ������ʽ��������ӯ��Ʈ�ݣ����к�ǿ��Ĥ�ṹ�ص㼰�ִ������ӵ��202�׸�ʽ�ͷ���200�׸ߵĿ��Ը�ϰ�ȫ�ǵĲ�����������ͥ�ǽ�Ӳӵģ�"
				+ "�����������780ƽ���׵���ͳ�׷����ǻ����Ƿ����ڵ�25�㣬�Ҿ��Ƕƽ�ģ����� һ����ӰԺ���������ҡ���������ҡ�һ��������������ר�õ��ݡ��ͷ������170ƽ���׵�780ƽ���ײ��ȡ����Ǽ��Ƶ귿�ۿ϶����ƣ����ҲҪ900��Ԫ����ͳ�׷���Ҫ1.8����Ԫ����ҾƵ�ӵ�а��������������˹��˹��ר��ס���ÿ�ֱ������������Ҳ�ɴ��ù�28��ר��Ļ�����ֱ��������15���ӿ��и�ϰ�����������������ں��ʲ����оͲ͵Ļ������ǽ���Ǳˮͧ�͵��������������ǾͲ�ǰ�������͵�������ۡ�";
		System.out.println(str.length());
		String str1 = "���������Ƶ�";
		OutputStream os = response.getOutputStream();
		os.write(str1.getBytes("UTF-8"));
		os.write(str.getBytes("UTF-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
