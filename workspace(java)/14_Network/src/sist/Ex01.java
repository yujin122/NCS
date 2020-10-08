package sist;

import java.net.*;

public class Ex01 {

	public static void main(String[] args) {
		
		try {
			// 내 컴퓨터의 IP 주소 
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP 주소 : " + local.getHostAddress());
			System.out.println();
			
			// 도메인 이름으로 IP 주소 확인
			InetAddress ia = InetAddress.getByName("www.naver.com");
			System.out.println("www.naver.com ip 주소 : " + ia.getHostAddress());
			System.out.println();
			
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress a : iaArr) {
				System.out.println("www.naver.com ip 주소 : " + a.getHostAddress());
			}
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
