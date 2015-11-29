package com.trip.logic;


public class CheckLogin {
	private static int length;
	private static String[] str1;
	private static String str2;
	private static String[] str3;
	private static String[] str4;

	/**
	 * 检测用户输入的信息是否正确的方法
	 * 
	 * @param username
	 *            客户端发送过来的用户名
	 * @param passsword
	 *            客户端发送过来的密码
	 * @return 如果匹配就返回true
	 */
	public static void main(String[] args){
		
		String result="3qqwwwwmmm2015-05-04qwert滕王阁qwert旺季（5月1日-10月7日）7:30-18:00；"
				+ "淡季（10月8日-次年4月30日）8:00-17:30。 qwert2015年05月07日 03:15:47qwert南昌市东湖区仿古街58号"
				+ "qwertimg/nanchang1.jpgqwert北京qwertmmm2015-05-12qwert滕王阁qwert旺季（5月1日-10月7日）7:30-18:00；"
				+ "淡季（10月8日-次年4月30日）8:00-17:30。 qwert2015年05月07日 03:15:57qwert南昌市东湖区仿古街58号"
				+ "qwertimg/nanchang1.jpgqwert南京qwertmmm2015-05-01qwert滕王阁qwert旺季（5月1日-10月7日）7:30-18:00；"
				+ "淡季（10月8日-次年4月30日）8:00-17:30。 qwert2015年05月07日 03:05:21qwert南昌市东湖区仿古街58号"
				+ "qwertimg/nanchang1.jpgqwert上海";
		str1= result.split("qq");
		length=Integer.parseInt(str1[0]);
		str2=str1[1];
		System.out.println(str2);
		str3=str2.split("mmm");
		System.out.print(str3.length);
		System.out.println("111"+str3[0]);
		for (int i = 0; i < str3.length; i++) {
			//str4=str3[i+1].split("qwert");
			System.out.println(str3[i]);
		}
	}
}
		
		
		
		
	
