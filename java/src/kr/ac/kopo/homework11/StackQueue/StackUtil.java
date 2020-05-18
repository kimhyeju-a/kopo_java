package kr.ac.kopo.homework11.StackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StackUtil {
	private List<String> stackList;
	private Scanner sc = new Scanner(System.in);
	private StackView stackView;
	public StackUtil() {
		stackList = new ArrayList<>();
	}
	
	private String scanStr(String msg) {
		System.out.print(msg);
		String stackValue = sc.nextLine();
		return stackValue;
	}
	
	//list의 크기가 1보다 작으면 배열이 비어있는 것임으로 참을 반환한다.
	public boolean isEmpty() {
		if(stackList.size() < 1) {
			System.out.println("Stack이 비어있습니다. 데이터를 먼저 삽입해주세요.");
			return true;
		}
		return false;
	}
	
	
	public void push() {
		String stackValue = scanStr("push() 데이러틑 입력해주세요 : ");
		stackList.add(stackValue);
	}
	
	//스택의 맨 위 객체를 가져온다. 객체를 스택에서 제거하지 않는다.
	public void peek() {
		if(isEmpty()) {
			stackView = new StackView();
		}
		System.out.println("peek() : " + stackList.get(stackList.size()-1));
	}
	
	//Stack은 LIFO(후입선출)방식을 채택한다. peek과 달리 객체를 스택에서 제거한다.
	public void pop() {
		if(isEmpty()) {
			stackView = new StackView();
		}
		stackList.remove(stackList.size()-1);
		System.out.println("pop() 을 수행하였습니다.");
	}
	
	public void print() {
		if(isEmpty()) {
			stackView = new StackView();
		}
		System.out.println("출력 : " + Arrays.toString(stackList.toArray()));
	}
	
}
