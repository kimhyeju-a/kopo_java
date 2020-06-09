package kr.ac.kopo.day17.homework.Echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClientMain {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("--------------------------------------------------");
			System.out.println(" 	사용법 : java EchoServerMain	host번호	port번호");
			System.out.println("--------------------------------------------------");
			System.exit(0);
		}
		String ip = args[0];
		int portNo = Integer.parseInt(args[1]);

		try {
			Socket socket = new Socket(ip, portNo);

			BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);

			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			while (true) {
				System.out.print("전송할 메시지를 입력하세요(quit입력시 종료) : ");
				String msg = keyBoard.readLine();
				if(msg.equalsIgnoreCase("quit")) {
					System.out.println("서버와의 접속종료");
					socket.close();
					break;
				}
				pw.println(msg);
				pw.flush();
				
				String echoMsg = br.readLine();
				System.out.println("서버에서 재전송한 메시지 : [" + echoMsg + "]");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
