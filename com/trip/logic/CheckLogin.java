package com.trip.logic;


public class CheckLogin {
	private static int length;
	private static String[] str1;
	private static String str2;
	private static String[] str3;
	private static String[] str4;

	/**
	 * ����û��������Ϣ�Ƿ���ȷ�ķ���
	 * 
	 * @param username
	 *            �ͻ��˷��͹������û���
	 * @param passsword
	 *            �ͻ��˷��͹���������
	 * @return ���ƥ��ͷ���true
	 */
	public static void main(String[] args){
		
		String result="3qqwwwwmmm2015-05-04qwert������qwert������5��1��-10��7�գ�7:30-18:00��"
				+ "������10��8��-����4��30�գ�8:00-17:30�� qwert2015��05��07�� 03:15:47qwert�ϲ��ж������¹Ž�58��"
				+ "qwertimg/nanchang1.jpgqwert����qwertmmm2015-05-12qwert������qwert������5��1��-10��7�գ�7:30-18:00��"
				+ "������10��8��-����4��30�գ�8:00-17:30�� qwert2015��05��07�� 03:15:57qwert�ϲ��ж������¹Ž�58��"
				+ "qwertimg/nanchang1.jpgqwert�Ͼ�qwertmmm2015-05-01qwert������qwert������5��1��-10��7�գ�7:30-18:00��"
				+ "������10��8��-����4��30�գ�8:00-17:30�� qwert2015��05��07�� 03:05:21qwert�ϲ��ж������¹Ž�58��"
				+ "qwertimg/nanchang1.jpgqwert�Ϻ�";
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
		
		
		
		
	
