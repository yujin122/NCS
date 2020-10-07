package sist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07 {

	public static void main(String[] args) {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("문자열을 입력하세요....");
		
		try {
			String str = br.readLine();
			
			System.out.println("입력받은 문자열 : " + str);
			
			br.close();isr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
