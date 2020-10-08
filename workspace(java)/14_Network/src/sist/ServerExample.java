package sist;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class ServerExample {

	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket();
			
			serverSocket.bind(new InetSocketAddress("localhost",5001));
		
			while(true) {
				System.out.println("[연결 기다림...]");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("[연결 수락...] : " + isa.getHostName());
				
				String message = null;
				byte[] bytes = null;
				// 클라이언트에서 보내온 데이터를 받자.
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0, readByteCount, "UTF-8");
				
				System.out.println("[데이터 받기 성공] : " + message);
				
				// 클라이언트로 데이터를 보내자
				OutputStream os = socket.getOutputStream();
				message = "Hello Client";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[클라이언트로 데이터 보내기 성공]");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
