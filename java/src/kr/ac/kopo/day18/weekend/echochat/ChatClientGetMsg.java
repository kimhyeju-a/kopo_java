package kr.ac.kopo.day18.weekend.echochat;

import java.io.BufferedReader;
import java.net.Socket;

public class ChatClientGetMsg extends Thread{
	Socket socket;
	BufferedReader br;
	String sendMsg;
	
	public ChatClientGetMsg(Socket socket, BufferedReader br) {
		this.socket = socket;
		this.br = br;
	}

	@Override
	public void run() {
		try {
			while(true) {
				sendMsg = br.readLine();
				if(sendMsg == null)
					break;
				System.out.println(sendMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
