package kr.ac.kopo.day200518;

import java.util.HashMap;
import java.util.Map;

//기능 클래스가 아닌 class cat 과 같이 할때 getter setter/ toString[info에 쓸 내용들] 작성해야함
//default 가 최대임
class Member {
	private String name;
	private String phone;
	
	public Member(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", phone=" + phone + "]";
	}


	/*
	//기존의 equals는 주소만을 비교한다. Object obj 묵시적 형변환이 되어 있다. => name과 phone은 접근할 수 없다. ==>명시적 형변환을 해야한다.
	@Override
	public boolean equals(Object obj) {
		
		Member m = (Member)obj; // 명시적 형변환을 해준다 : 묵시적 형변환이 된 부모 객체는 자식객체에서 자기 자신이 선언된 곳만 접근이 가능하다.
		if(this.name.equals(m.name) && this.phone.equals(m.phone))
			return true;
		return false;
	}

	//hashCode 가 이런식으로  return 하게 되면 겹칠 경우가 생길 수도 있다. ==> 이클립스에서 generate hashCode().. 를 클릭하면
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.name.hashCode() + this.phone.hashCode();
	}
	*/
	
	
}

class Car {
	private String name;
	private String id;
	
	public Car(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	
}
public class MapMain02 {

	public static void main(String[] args) {
		
		
		Map<Member, Car> list = new HashMap<>();
		
		list.put(new Member("홍길동","010-1111-2222"), new Car("소나타","34거1456"));
		list.put(new Member("윤길동", "010-3333-4444"), new Car("모닝","63나 8843"));
		
		list.put(new Member("홍길동", "010-1111-2222"), new Car("k7","53소3423")); 
		//key point !! : 키의 중복을 허용하지 않는데 3대로 나옴 ==> 1번째 홍길동과 3번째 홍길동을 같은 홍길동으로 보지 않음
		//equals 를 오버라이딩 했지만, 3대로 나오는 이유  ==> hascode도 오버라이딩 해줘야한다.
		//자바에서는 어떤 객체가 서로 같은 객체라고 인식하는 법은 1. equals가 true 이면서 , 2.해시코드(jvm이 가지고 있는 가상의 주소)가 같아야한다.
		
		// 2대가 출력되게 하기 위해서는 equals, hascode 가 오버라이딩 해줘야 한다.
		System.out.println("등록된 차량대수 : " + list.size() + "대");
		Member m = new Member("홍길동", "010-1111-2222");
		//@주소가 나오는 이유 : Object toString에 있음 이게 싫으면 오버라이딩 
		System.out.println(m.toString());
		
		
		
		/*
		// 키의 중복을 허용하지 않는데 3대로 나옴 인스턴스 객체를 따로 만들었기 때문에 주솟값을 비교하게 된다 ==> 같지 않다.
		Member m = new Member("홍길동", "010-1111-2222");
		Member m2 = new Member("홍길동", "010-1111-2222");
		
		System.out.println("m == m2 : " + (m == m2));
		//Object메소드에는 객체와 객체를 비교할 수 있는 equals라는 메소드가 존재한다. - Object가 부모클래스이기 때문에 내 것인것 처럼 사용이 가능
		System.out.println("equals()" + m.equals(m2)); 
		// ㄴ false 가 나옴 -> why? 문서를 따라가보면 주소값을 비교하게 되어 있음 overridding 을 하여 사용 하도록 하고 있음 ["Hello".equals("HELLO") ==> string에서오버라이딩함]
		// 해결법 : Object 클래스의 equals메소드를 오버라이딩을 한다 Member 클래스에 있음
		*/
		/*
		String str = "Hello world";
		String str2 = new String("Hello world");
		
		System.out.println("str == str2 : " + (str == str2));
		System.out.println("str equals () : " + str.equals(str2));
		// hashcode 의 값이 같다 ->
		System.out.println("str hashcode() : " + str.hashCode());
		System.out.println("str2 hashcode() : " + str2.hashCode());
		
		*/
	}
}
