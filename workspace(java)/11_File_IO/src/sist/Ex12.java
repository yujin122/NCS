package sist;

import java.io.*;

public class Ex12 {
	
	public static void listDirectory(File dir) {
		System.out.println("----- " + dir.getPath() + "의 서브 리스트 -----");

		File[] subFiles = dir.listFiles();

		for (int i = 0; i < subFiles.length; i++) {
			File f = subFiles[i];
			long time = f.lastModified();
			System.out.print(f.getName() + "\t");
			System.out.print("파일 크기 : " + f.length() + "\t");
			// %t는 날짜형 데이터에 사용하는 형식
			// b : 월, d : 일, a : 요일, T : 시간
			System.out.printf("수정한 시간 : %tb %td %ta %tT \n", time,time,time,time);
		}
	}

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("C:/Windows/system.ini");
			
			int readByte;
			
			while(true) {
				readByte = fr.read();
				
				if(readByte == -1) {
					break;
				}
				
				System.out.print((char)readByte);
			}
			
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
		File file = new File("C:/Windows/system.ini");
		
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		System.out.println(file.getName());
		System.out.println();
		
		String res = null;
		
		if(file.isFile()) {
			res = "파일";
		}else if(file.isDirectory()) {
			res = "디렉토리";
		}
		
		System.out.println(file.getPath() + " 은(는)" + res + "입니다.");
		System.out.println();
		
		listDirectory(new File("C:/Windows"));
	}

}
