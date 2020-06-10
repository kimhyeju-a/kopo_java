package kr.ac.kopo.day18;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class SenderMain {

	public static void main(String[] args) {
		
		try {
			DatagramSocket socket = new DatagramSocket();
			
			System.out.println("[송신 시작]");
			
			for(int i = 1; i <= 10 ; i++) {
				String msg = "여기서이러시면안됩니다.";
				byte[] bytes = msg.getBytes();
				SocketAddress addr = new InetSocketAddress("localhost", 10002);
				
				DatagramPacket packet = new DatagramPacket(bytes,bytes.length,addr);
				
				Thread.sleep(1000);
				socket.send(packet);
				System.out.println("전송한 데이터 크기 : " + bytes.length);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
