package sist;

import java.io.*;

public class Ex05 {

	public static void main(String[] args) {

		InputStream is = null;
		
		int readByte;
		
		try {
			is = new FileInputStream("C:/test/sample.txt");
			
			while(true) {	
				readByte = is.read();
				
				// 더이상 읽을 데이터가 없다.
				if(readByte == -1) {
					break;
				}
				
				System.out.print((char)readByte);
			}
			is.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
