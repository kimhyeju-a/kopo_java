package kr.ac.kopo.day06;

public class Member {
	String name;		// 이름
	int age;			// 나이
	String bloodType;	// 혈액형

	Member(){
		this("알수없음", -1 , "알수없음");
	}
	Member(String name){
		this(name, -1, "알수없음");
	}
	
	Member(String name, int age){
		this(name, age, "알수없음");

	}
	
	/*
	Member(){
		name = "알수없음";
		age = -1;
		bloodType = "알수없음";
	}
	Member(String n){
		name = n;
		age = -1;
		bloodType = "알수없음";
	}
	
	Member(String n, int a){
		name = n;
		age = a;
		bloodType = "알수없음";
	}
	/*
	// n , a, bt 라고 쓸 경우 각각의 매개변수가 무엇을 의미하는지 불분명함
	//멤버변수에도 name이 있고, 매개변수에도 name 이 있음 
	//--> 왼쪽은 멤버변수의 name, 오른쪽은 매개변수의 name
	/*
	 * 지역변수 먼저 찾고, 지역변수에서 없으면 멤버변수에서 찾는다. 
	 * name = name; 일때 두개의 name 모두 지역변수를 의미한다.
	 * 따라서 this.키워드를 써줌으로써 멤버변수임을 명시해준다.
	 */
	Member(String name, int age, String bloodType){
		this.name = name;
		this.age = age;
		this.bloodType = bloodType;
	}
	
	void info() {
		System.out.println("이름: "+ name +", 나이 : " + (age == -1 ? "알수없음" : age) + ", 혈액형  : " + bloodType);
	}
}
