package kr.ac.kopo.day200520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import kr.ac.kopo.util.FileClose;

/*
	콘솔에서 명령어를 입력하여 원본파일을 대상파일에 저장하는 프로그램
	$FileIOMain07 aaa.txt bbb.txt
				 |-> args는 여기서 부터만 기억한다. [우리가 만들었던 프로그램의 args.length는 0이다.]
		- aaa.txt / bbb.txt가 입력되었는지 확인하는 것 : String[] args
		
	콘솔모드가 익숙하지 않다. 매개변수를 입력하게 해주는게 있음 Run -> Run Configuration -> Arguments
 */
public class FileIOMain07 {

	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("args length : " + args.length);
			System.out.println("사용법 : java FileIOMain07 원본파일명 대상파일명");
			System.exit(0);
		}
		
		
		// catch문으로 FileNotFoundException 을 쓰면 다음줄을 쓰지 않아도된다.
		File oriFile = new File(args[0]);
		if(!oriFile.exists()) {
			System.out.println("[" + args[0] + "]파일이 존재하지 않습니다.");
			System.exit(0);
		}
		
		
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			//fr = new FileReader(args[0]);
			fr = new FileReader(oriFile);
			br = new BufferedReader(fr);
			
			fw = new FileWriter(args[1]);
			bw = new BufferedWriter(fw);
			
			while(true) {
				String data = br.readLine();
				if(data == null) break;
				bw.write(data);
				bw.newLine();
			}
			bw.flush();
			
			System.out.printf("[%s] -> [%s] 복사완료 \n", args[0], args[1]);
		} catch(FileNotFoundException fnfe) {
			System.out.println("[" + args[0] + "]파일이 존재하지 않습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(br, fr);
			FileClose.close(bw, fw);
		}
	}
}
