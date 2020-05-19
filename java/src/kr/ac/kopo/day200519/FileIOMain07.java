package kr.ac.kopo.day200519;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import kr.ac.kopo.util.FileClose;

public class FileIOMain07 {

	public static void main(String[] args) {
		
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			fr = new FileReader("iotest/FileIOMain03.java");
			fw = new FileWriter("iotest/FileIOMain03-1.java.txt");
			
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			pw = new PrintWriter(bw);
			
			while(true) {
				// \n은 문자열의 끝값으로 인식이 되기 때문에 \n는 버퍼에 들어가지 않는다 따라서 \n도 저장이 되어야 한다.
				String str = br.readLine();
				if(str == null) break;
				//얘네 대신에
//				bw.write(str);
//				bw.newLine();
				pw.println(str);
			}
			pw.flush();
			/*
			while(true) {
				// \n은 문자열의 끝값으로 인식이 되기 때문에 \n는 버퍼에 들어가지 않는다 따라서 \n도 저장이 되어야 한다.
				String str = br.readLine();
				if(str == null) break;
				bw.write(str);
				//알아서 os에 맞춰서 자바가 enter라는 문자를 넣어줘! ==> newLine이 있다.
//				bw.write('\n');
				bw.newLine();
			}
			*/
			/*
			while(true) {
				int c = br.read();
				if(c == -1) break;
				bw.write(c);
			}
			bw.flush();
			*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			/*
			 * 모든 bufferedReader와 BufferedWriter는 Reader와 Writer를 상속받는다. 
			 * 		==> FileWriter가 들어오던 BufferedReader가 들어오던 writer로 받고 reader로 받는다.
			 */
			FileClose.close(pw);
			FileClose.close(br,fr);
			FileClose.close(bw,fw);
		
//			FileClose.close(br,fw);
//			FileClose.close(fr,fw);
			/*
			FileClose.close(br);
			FileClose.close(bw);
			FileClose.close(fr);
			FileClose.close(fw);
			*/
			
		}
	}
}
