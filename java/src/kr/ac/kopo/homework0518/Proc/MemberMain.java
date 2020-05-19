package kr.ac.kopo.homework0518.Proc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			List<Member> memberList = new ArrayList<>();

			memberList.add(new Member("aaa", "1111"));
			memberList.add(new Member("bbb", "2222"));
			memberList.add(new Member("ccc", "3333"));
			memberList.add(new Member("ddd", "4444"));

			System.out.println("패스워드 변경서비스 입니다...");
			System.out.print("아이디를 입력하세요 : ");
			String id = sc.nextLine();

			Member user = new Member(id);
			boolean bool = memberList.contains(user);

			if (!bool) {
//				System.out.println("입력하신 아이디 [ " + id + "]는 존재하지 않습니다.");
//				System.out.println("시스템을 종료합니다");
//				System.exit(0);
				throw new CheckIDPASSException(1);
			}

			int index = memberList.indexOf(user);

			System.out.println("현재 패스워드를 입력하세요 : ");
			String password = sc.nextLine();
			// exception으로 처리해도 됨 catch에서 처리하면됨
			if (!memberList.get(index).getPassword().equals(password)) {
//			System.out.println("패스워드가 올바르지 않습니다.");
//			System.out.println("시스템을 종료합니다");
//			System.exit(0);
				throw new CheckIDPASSException(2);
			}

			System.out.print("변경할 패스워드를 입력하세요 : ");
			String newPassword = sc.nextLine();
			// 원래 라면 이렇게 해야함
			/*
			 * memberList.remove(index); memberList.add(index, new Member(id, newPassword));
			 */
			// set(index,Object) : index의 객체를 Object로 변환시킴
			// Replaces the element at the specified position in this list with the
			// specified element (optional operation).
			memberList.set(index, new Member(id, newPassword));

			System.out.println("< 전체 회원 목록 >");
			Iterator<Member> ite = memberList.iterator();
			while (ite.hasNext()) {
				// toString 을 오버로딩 했기 때문에 가능
				// next() => 멤버변수를 리턴한다. => .toString()을 자동적으로 만들어준다.
				System.out.println(ite.next());
			}
		} catch (CheckIDPASSException e) {
			System.out.println(e.getMessage());
			System.out.println("서비스를 종료합니다.");
		}
	}
}
