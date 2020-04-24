package kr.ac.kopo.homework08;

public class Square extends Rectangle {
	/*
	 * 교수님.. 이렇게 하는게 아닌 것 같은데... 머리로는 아닌것같다고 생각하는데 상속을 어떻게 활용해야할까...생각하다가 결국 이방법을 선택했습니다...
	 * 혹시 내일 오전 리뷰해주실때 이부분을 어떻게 해야 객체지향적으로 잘만든건지 알려주시면 안될까요 ㅠㅠ 
	 */
	public Square(){}
	
	public Square(int width) {
		this.setWidth(width);
		this.setHeight(width);
	}
	
	@Override
	public void print() {
		System.out.println("높이 : " + this.getHeight() + ", 밑변 : " + this.getWidth() + "인 정사각형의 넓이는 " + this.getArea() + "입니다.");
	}

}