package kr.ac.kopo.day08.extend;


public class Manager extends Employee {
	
	private Employee[] empList;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int no, String name, String grade, int salary, Employee[] empList) {
		super(no, name, grade, salary);
		this.empList = empList;
	}

	public Employee[] getEmpList() {
		return empList;
	}

	public void setEmpList(Employee[] empList) {
		this.empList = empList;
	}
	
	//오버라이딩
 	@Override
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
