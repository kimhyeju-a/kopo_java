package kr.ac.kopo.homework0518;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberUtil {
	private Scanner sc;
	private List<Member> listMember = new ArrayList<>();

	public MemberUtil() {
		sc = new Scanner(System.in);
	}

	public void start() {
		dataSetting();
		System.out.println("패스워드 변경서비스입니다.");
		System.out.print("변경할 아이디를 입력하세요 : ");
		String id = sc.nextLine();
		findIdChangePwd(id);
		print();
	}

	private void dataSetting() {
		listMember.add(new Member("aaa", "1111"));
		listMember.add(new Member("bbb", "2222"));
		listMember.add(new Member("ccc", "3333"));
		listMember.add(new Member("ddd", "4444"));
	}
	
	private void findIdChangePwd(String id) {
		int i = 0;
		while (i < listMember.size()) {
			// id와 같은 list항목을 찾고 비밀버호 관련 처리를 한 후, break로 반복문 빠져나옴
			if (listMember.get(i).getId().equals(id)) {
				System.out.print("현재 패스워드를 입력하세요 : ");
				String password = sc.nextLine();
				
				if (listMember.get(i).getPassword().equals(password)) {
					System.out.print("변경할 패스워드를 입력하세요 : ");
					String newPassword = sc.nextLine();
					listMember.get(i).setPassword(newPassword);
					System.out.println("패스워드를 변경하였습니다.");
					
				} else {
					System.out.println("패스워드가 올바르지 않습니다.");
					System.out.println("서비스를 종료합니다.");
					System.exit(0);
				}
				break;
			}
			i++;
		}
		if (i == listMember.size()) {
			System.out.println("입력하신 아이디 [" + id + "]는 존재하지 않습니다.");
			System.out.println("서비스를 종료합니다.");
			System.exit(0);
		}
	}
	
	private void print() {
		System.out.println("< 전체 회원 목록 >");
		for(Member m : listMember) {
			System.out.println("id : " + m.getId() +", password : " + m.getPassword());
		}
	}
		
}
