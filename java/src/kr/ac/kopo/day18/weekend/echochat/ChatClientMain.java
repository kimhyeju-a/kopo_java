package kr.ac.kopo.day18.weekend.echochat;

public class ChatClientMain {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("--------------------------------------------------");
			System.out.println(" 	사용법 : java EchoServerMain	ID	ip");
			System.out.println("--------------------------------------------------");
			System.exit(0);
		}
		String userId = args[0];
		String ip = args[1];

		new ChatClient(userId, ip);
	}
}
