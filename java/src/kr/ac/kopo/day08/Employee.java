package kr.ac.kopo.day08;

public class Employee {

	int no; // 사원번호
	String name; // 사원명
	String grade; // 직급
	int salary; // 연봉

	// 습관적으로 매개변수있는 생성자가 있다면 기본생성자를 만들어야 한다.
	public Employee() {
		System.out.println("Employee생성자 호출");
	}

	public Employee(int no, String name, String grade, int salary) {
		this.no = no;
		this.name = name;
		this.grade = grade;
		this.salary = salary;
	}

	public void info() {
		System.out.println("사원번호 : " + no + ", 사원명 : " + name + ", 직급 : " + grade + ", 연봉 : " + salary + "만원");
	}
	
	public int getNo() {
		return no;
	}
}
