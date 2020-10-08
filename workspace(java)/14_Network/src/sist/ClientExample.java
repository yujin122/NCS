package sist;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;


public class ClientExample {

	public static void main(String[] args) {
		
		// 서버에 연결 요청
		try {
			Socket socket = new Socket();
			
			System.out.println("[연결 요청]");
			
			socket.connect(new InetSocketAddress("localhost",5001));
			
			System.out.println("[연결 성공]");
			
			String message = null;
			byte[] bytes = null;
			// 서버에 데이터를 보내자
			OutputStream os = socket.getOutputStream();
			message = "Hello Server";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			
			
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCount = is.read(bytes);
			message = new String(bytes, 0, readByteCount, "UTF-8");
			System.out.println("[데이터 받기 성공] : " + message);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
