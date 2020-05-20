package kr.ac.kopo.homework0519.board;

import java.time.LocalDate;

public class Board {
	
	int no;
	String title;
	String author;
	LocalDate time;
	public Board() {
		
	}
	public Board(int no, String title, String author, LocalDate time) {
		this.no = no;
		this.title = title;
		this.author = author;
		this.time = time;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate date) {
		this.time = date;
	}

	public void info() {
		//삭제했을 때에는 정보를 보여주면 안됨
		if(title!=null) {			
			System.out.printf("%d\t%s\t%s\t%s\t\n",no ,title ,author, time);
		}
	}
}
