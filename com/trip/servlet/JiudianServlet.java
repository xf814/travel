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
		String str="阿拉伯塔酒店是世界上建筑高度最高的七星级酒店，开业于1999年12月，有高级客房202间，建立在离海岸线278米处的人工岛Jumeirah Beach Resort上。伯瓷糅合了最新的建筑及工程科技，迷人的景致及造型，使它看上去仿佛和天空融为一体。"
				+ "2005年2月22日排名世界第一的瑞士选手费德勒和美国传奇老将阿加西在参加迪拜公开赛间隙，来到号称世界最豪华的酒店，位于迪拜海域的“阿拉伯塔”饭店顶端的一个独一无二的空中网球场进行一场别开生面的友谊赛，据称此网球场原是直升机停机坪，距离地面200多米，让人心惊肉跳。看起来好像是正在行进中的帆船形象的酒店建在海滨的一个人工岛上，是一个帆船形的塔状建筑。它建在离海岸线280米处的人工岛Jumeirah Beach Resort上。 采用双层膜结构建筑形式，造型轻盈、飘逸，具有很强的膜结构特点及现代风格。它拥有202套复式客房、200米高的可以俯瞰迪拜全城的餐厅。它的中庭是金灿灿的，"
				+ "它的最豪华的780平方米的总统套房更是华丽非凡，在第25层，家具是镀金的，设有 一个电影院、两间卧室、两间起居室、一个餐厅，出入有专用电梯。客房面积从170平方米到780平方米不等。七星级酒店房价肯定不菲，最低也要900美元，总统套房则要1.8万美元。这家酒店拥有八辆宝马和两辆劳斯莱斯，专供住店旅客直接往返机场，也可从旅馆28层专设的机场坐直升机，花15分钟空中俯瞰迪拜美景。客人如果想在海鲜餐厅中就餐的话，他们将被潜水艇送到餐厅，这样他们就餐前可以欣赏到海底奇观。";
		System.out.println(str.length());
		String str1 = "阿拉伯塔酒店";
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
