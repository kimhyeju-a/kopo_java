package kr.ac.kopo.day18.weekend.echochat;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {
	private Map<String, PrintWriter> map;

	public ChatServer() {
		ServerStart();
	}

	public void ServerStart() {
		try (ServerSocket server = new ServerSocket(10005);) {
			map = new HashMap<String, PrintWriter>();
			while (true) {
				Socket client = server.accept();
				EchoThreadServer etc = new EchoThreadServer(client, map);
				etc.start();
			}
		} catch (Exception e) {
		}
	}
}
