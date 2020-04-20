package kr.ac.kopo.day07;

public class Employee {

	private String		name; 				// 사원명
	private int			salary;				// 연봉
	private static int	totalEmployeeCount; // 총사원수
	
	public Employee() {
		totalEmployeeCount++;
	}
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
		totalEmployeeCount++;
	}
	
	public void info() {
		System.out.println("사원명 : " + name + ", 연봉 : " + salary + "만원");
		//이미 static변수도 만들어져있기 때문에 에러가 나지 않는다.
		System.out.println("입사한 총 사원수 : " + Employee.totalEmployeeCount +"명");
	}
	
	static public void totalEmployeeInfo() {
		System.out.println("입사한 총 사원수 : " + Employee.totalEmployeeCount + "명");
	}
}
