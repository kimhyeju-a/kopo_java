package kr.ac.kopo.day18.weekend.echochat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	private String userId;
	private String ip;

	public ChatClient(String userId, String ip) {
		this.userId = userId;
		this.ip = ip;
		chatClientExecute();
	}

	public void chatClientExecute() {

		try {
			Socket socket = new Socket(ip, 10005);

			BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);

			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("[" + userId + "]님이 접속했습니다.");
			pw.println(userId);
			pw.flush();

			ChatClientGetMsg getMsg = new ChatClientGetMsg(socket, br);
			getMsg.start();
			while (true) {
				String msg = keyBoard.readLine();
				if (msg.equalsIgnoreCase("/quit")) {
					System.out.println("채팅방을 종료합니다.");
					System.exit(0);
				}
				pw.println(msg);
				pw.flush();
			}
		} catch (IOException e) {
		}
	}
}
