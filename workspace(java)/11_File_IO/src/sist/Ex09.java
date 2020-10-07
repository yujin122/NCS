package sist;

import java.io.*;

/*
 * 파일 복사
 * - Koala.jpg : 원본 이미지 파일
 * - Copied.jpg : 복사 이미지 파일
 */

public class Ex09 {

	public static void main(String[] args) {

		try {
			// 원본 이미지 파일
			FileInputStream fis = new FileInputStream("C:/test/Koala.jpg");
			
			// 원본 이미지 파일이 복사되어 저장될 파일 이름.
			FileOutputStream fos = new FileOutputStream("C:/test/Copied.jpg");
			
			int readByte;
			
			while(true) {
				readByte = fis.read();
				
				if(readByte == -1) {
					break;
				}
				
				fos.write(readByte);
			}
			
			fos.close(); fis.close();
			System.out.println("복사 완료!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
