package sist;

import java.io.*;

public class Ex06 {

	public static void main(String[] args) {

		Reader isr = null;
		
		int readByte;
		
		try {
			isr = new FileReader("C:\\Users\\yyj01\\OneDrive\\문서\\GitHub\\NCS\\workspace(java)\\11_File_IO\\src\\sist\\Ex04.java");
			
			while(true) {
				readByte = isr.read();
				
				if(readByte == -1) {
					break;
				}
				
				System.out.print((char)readByte);
			}
			
			isr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
