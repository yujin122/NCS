package sist;

public class test4 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
				
		System.out.println("입력받은 숫자 ==> " + num);
		
		int m_5000 = num / 5000;
		
		int m_1000 = (num%5000) / 1000;
		
		int m_500 = (num%1000) / 500;
		
		int m_100 = (num%500) / 100;
		
		int m_50 = (num%100) / 50;
		
		int m_10 = (num%50) / 10;
		
		int m_1 = (num%10);
		
		System.out.println("오천원 지폐 : " + m_5000 + "장");
		System.out.println("천원 지폐 : " + m_1000 + "장");
		System.out.println("오백원 동전 : " + m_500 + "개");
		System.out.println("백원 동전 : " + m_100 + "개");
		System.out.println("오십원 동전 : " + m_50 + "개");
		System.out.println("십원 동전 : " + m_10 + "개");
		System.out.println("일원 동전 : " + m_1 + "개");
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
