package kr.ac.kopo.day200519;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMain {
	public static void main(String[] args) {
		File fileObj = new File("iotest\\aaa.txt");
		String name = fileObj.getName();
		System.out.println("name: " + name);
		System.out.println("parent: " + fileObj.getParent());
		System.out.println("path:" + fileObj.getPath());
		System.out.println("Ab Path:" + fileObj.getAbsolutePath());

		boolean bool = fileObj.isFile();
		// file이 없으면 isFile이건 isnotFile이건 다 false임 --> exists();
//      System.out.println(bool? "파일입니다." : "디렉토리입니다.");
		System.out.println(bool ? "파일입니다." : "파일이아닙니다.");

		bool = fileObj.isDirectory();
		System.out.println(bool ? "디렉토리입니다." : "파일입니다.");

		bool = fileObj.exists();
		System.out.println(name + (bool ? " : 존재합니다." : " : 존재하지 않습니다."));
		
		long length = fileObj.length();
		System.out.println("파일 크기  : " + length + "byte(s)");
		
		long lastTime = fileObj.lastModified();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:s");
		System.out.println("마지막수정시간 : " +sdf.format(new Date(lastTime)));
		
		bool = fileObj.canWrite();
		System.out.println(bool ? "쓰기 가능" : "쓰기 불가능");
		
		bool = fileObj.canRead();
		System.out.println(bool ? "읽기 가능" : "읽기불가능");
		
		
	}

}