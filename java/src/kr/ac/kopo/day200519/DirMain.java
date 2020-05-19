package kr.ac.kopo.day200519;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirMain {
	
	public static void main(String[] args) {
		
		File dirObj = new File("test");
		
		boolean bool = dirObj.exists();
		System.out.println(bool ? "유효한 디렉토리입니다." : "유효하지 않는 디렉토리입니다.");
		
		if(!bool)
			dirObj.mkdir();
		
		//내폴더에 들어있는 여러개의 다른 아이들이 누구있냐 
		String[] list = dirObj.list();
		System.out.println("-------------------------------------");
		System.out.println("\t" + dirObj.getName()+ "디렉토리 정보");
		System.out.println("-------------------------------------");
		for(String element : list) {
			System.out.println(element);
		}
		System.out.println("-------------------------------------");
		
		//새로운 디렉토리 만들기 - 이미 만들어진 것은 생성 실패
		File newDirObj = new File("iotest/하마");
		System.out.println(newDirObj.mkdir()? "dir 생성 성공" : "dir 생성 실패");
		String path = newDirObj.getPath();
		String name = newDirObj.getName();
		System.out.println(path);
		String[] path2 = path.split("\\\\");
		System.out.println(Arrays.toString(path2));
		//mkdirs : 중간경로에 없는 폴더도 만든다.
		newDirObj = new File("iotest/새폴더/오리");
		System.out.println(newDirObj.mkdirs() ? "dir 생성 성공" : "dir 생성 실패");
		
		//child가 기준임 오리만 지워짐
		//newDirObj = new File("iotest/새폴더");		//만약 파일안에 정보가 있다면 삭제할 수 없다
		bool = newDirObj.delete();
		System.out.println(bool ? "삭제성공" : "삭제실패");
		
		//빈폴더가 아닌 
	}
}
