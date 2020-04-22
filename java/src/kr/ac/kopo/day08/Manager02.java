package kr.ac.kopo.day08;

public class Manager02 extends Employee{

	Employee[] empList; // 관리 사원 목록
	public Manager02() {	
	}
	public Manager02(int no, String name, String grade, int salary, Employee[] empList) {
		//부모생성자의 변수가 private이므로 super([인자, 인자 ...]) 를 사용하여 접근해야 한다.
		super(no, name, grade, salary);
		this.empList = empList;
		
	}
	public void info() {
		//this.info()를 하게 되면 manager02의 this인지 employee의 info인지 알수 없어 스택오버플로우가 나온다.
		super.info();
		System.out.println("==============================================");
		System.out.println("\t\t< 관리사원 목록 >");
		System.out.println("==============================================");
		for(Employee e : empList) {
			e.info();
		}
		System.out.println("==============================================");
	}
}
