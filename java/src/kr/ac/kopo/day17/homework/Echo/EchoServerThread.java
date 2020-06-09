package kr.ac.kopo.day17.homework.Echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

class EchoServerThread extends Thread {
	Socket client;

	public EchoServerThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		InputStream is;
		try {
			is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);

			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					System.out.println("[" + client.getInetAddress() + "]님 접속해제");
					client.close();
					break;
				}
				System.out.println("[" + client.getInetAddress() + "] 보낸 메시지 : " + msg);

				pw.println(msg);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}