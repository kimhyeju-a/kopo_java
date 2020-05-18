package kr.ac.kopo.homework11.StackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QueueUtil {
	private List<String> queueList;
	private Scanner sc = new Scanner(System.in);
	private QueueView queueView;
	
	public QueueUtil() {
		queueList = new ArrayList<>();
	}
	private String scanStr(String msg) {
		System.out.print(msg);
		String queueValue = sc.nextLine();
		return queueValue;
	}
	
	//list의 크기가 1보다 작으면 배열이 비어있는 것임으로 참을 반환한다.
	public boolean isEmpty() {
		if(queueList.size() < 1) {
			System.out.println("Stack이 비어있습니다. 데이터를 먼저 삽입해주세요.");
			return true;
		}
		return false;
	}
	
	public void offer() {
		String queueValue = scanStr("offer() 데이러틑 입력해주세요 : ");
		queueList.add(queueValue);
	}
	
	//Queue는 FIFO(선입선출)방식을 채택하므로 가장 첫번째 데이터를 가져온다.
	public void peek() {
		if(isEmpty()) {
			queueView = new QueueView();
		}
		System.out.println("peek() : " + queueList.get(0));
	}
	
	//Queue의 가장 첫번째로 들어온 데이터를 삭제한다.
	public void poll() {
		if(isEmpty()) {
			queueView = new QueueView();
		}
		queueList.remove(0);
		System.out.println("poll() 수행하였습니다.");
	}
	
	public void print() {
		if(isEmpty()) {
			queueView = new QueueView();
		}
		System.out.println("출력 : " + Arrays.toString(queueList.toArray()));
	}
}
