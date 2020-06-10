package kr.ac.kopo.day18;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class ReceiverMain {

	public static void main(String[] args) {
		
		try {
			DatagramSocket socket = new DatagramSocket(10002);
			//받는것을 패킷으로 받는 것이 목적이라서, address가 없어도 된다. DatagramPacket생성자 첫번째
			
			System.out.println("[수신 시작]");
			
			byte[] buf = new byte[100];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			while(true){
				
				socket.receive(packet);
				String msg = new String(packet.getData());
				System.out.println("[수신된 내용] : " + msg);
//			주소값이 나온다.
//			System.out.println("[수신된 내용 ] :" + packet);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
