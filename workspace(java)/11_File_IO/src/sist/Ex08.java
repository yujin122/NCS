package sist;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * 1. FileInputStream / FileOutputStream
 * 	  - 1바이트 단위로 파일을 처리하는 바이트 기반 입출력 스트림
 * 	  - 그림(이미지), 오디오 파일 등 모든 종류의 파일 처리가 가능함.
 * 
 * 2. FileReader / FileWriter
 * 	  - 2바이트 단위로 파일을 처리하는 문자 기반 입출력 스트림
 * 	  - 문자 단위로 처리를 하기 때문에 그림, 오디오 파일들은 처리가 불가능
 */

public class Ex08 {

	public static void main(String[] args) {
		
		long start,end;
		
		// 1. 바이트 스트림을 사용한 경우
		try {
			FileInputStream fis = new FileInputStream("C:/test/Koala.jpg");
			
			// currentTimeMillis() : 시스템의 현재 시간을 1/1000초로 환산
			start = System.currentTimeMillis();
			
			while(fis.read() != -1) {	}
			
			end = System.currentTimeMillis();
			
			System.out.println("바이트 스트림을 사용한 경우 : " + (end - start) + "ms");
			
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 2. 보조스트림을 사용한 경우
		
		try {
			FileInputStream fis1 = new FileInputStream("C:/test/Koala.jpg");
			BufferedInputStream bis = new BufferedInputStream(fis1);
			
			start = System.currentTimeMillis();
			
			while(bis.read() != -1) { }
			
			end = System.currentTimeMillis();
			
			System.out.println("보조 스트림을 사용한 경우 : " + (end-start) + "ms");
			
			bis.close(); fis1.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
