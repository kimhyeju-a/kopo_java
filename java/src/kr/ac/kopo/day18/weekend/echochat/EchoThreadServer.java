package kr.ac.kopo.day18.weekend.echochat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;

public class EchoThreadServer extends Thread {
	private Socket socket;
	private Map<String, PrintWriter> map;
	private String userId;

	private BufferedReader br;
	private PrintWriter pw;

	public EchoThreadServer(Socket client, Map<String, PrintWriter> map) {
		socket = client;
		this.map = map;
		try {
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			pw = new PrintWriter(client.getOutputStream());

			userId = br.readLine();
			System.out.println("접속한 사용자의 아이디는 " + userId + "입니다.");
			sendMsg("[" + userId + "] 님이 접속했습니다.");
			synchronized (map) {
				map.put(userId, pw);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String receiveMsg;

		try {
			while (true) {
				try {
					receiveMsg = br.readLine();
					// /to 가 존재하면 wishper 수행
					if (receiveMsg.indexOf("/to") >= 0) {
						wishper(receiveMsg);
					} else {
						sendMsg("[" + userId + "] : " + receiveMsg);
					}
				} catch (SocketException se) {
					// Client에서 /quit를 하면 System.exit(0)으로 접속을 끊어버려 강제로 예외 생성하도록 함
					String exitUser = "[" + userId + "] 님이 종료하셨습니다.";
					System.out.println(exitUser);
					sendMsg(exitUser);
					synchronized (map) {
						map.remove(userId);
					}
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void wishper(String receiveMsg) {
		int beginIdx = receiveMsg.indexOf(" ") + 1;
		int endIdx = receiveMsg.indexOf(" ", beginIdx);
		String message = null;
		PrintWriter pw = map.get(userId);
		if (endIdx == -1) {
			pw.println("잘못입력하셨습니다. 귓속말 사용법 : /to toID 메시지");
			pw.flush();
		} else {
			String toId = receiveMsg.substring(beginIdx, endIdx);
			if (!map.containsKey(toId)) {
				pw.println("아이디가 없습니다. 확인해주세요.");
				pw.flush();
			} else {
				pw = map.get(toId);
				message = receiveMsg.substring(endIdx + 1);
				pw.println("[" + userId + "님이 다음 귓속말을 보냈습니다. ] : " + message);
				pw.flush();
			}
		}
	}

	private void sendMsg(String msg) {
		synchronized (map) {
			try {
				for (PrintWriter pw : map.values()) {
					pw.println(msg);
					pw.flush();
				}
			} catch (Exception e) {
			}
		}
	}
}
