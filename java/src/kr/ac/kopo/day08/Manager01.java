package kr.ac.kopo.day08;

public class Manager01 extends Employee {

	Employee[] empList; // 관리 사원 목록
	public Manager01() {	
	}
	public Manager01(int no, String name, String grade, int salary, Employee[] empList) {
		this.no = no;
		//super.no = no; 도 가능하다. 
		this.name = name;
		this.grade = grade;
		this.salary = salary;
		this.empList = empList;
		
	}
	public void info() {
		System.out.println("사원번호 : " + no + ", 사원명 : " + name + ", 직급 : " + grade + ", 연봉 : " + salary + "만원");
		System.out.println("==============================================");
		System.out.println("\t\t< 관리사원 목록 >");
		System.out.println("==============================================");
		for(Employee e : empList) {
			e.info();
		}
		System.out.println("==============================================");
	}
}
