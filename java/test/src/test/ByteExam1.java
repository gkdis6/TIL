package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteExam1 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
 		
		try {
			fis = new FileInputStream("read.txt");
			fos = new FileOutputStream("byte.txt");
				
			int readData = -1;
			try {
				while((readData = fis.read()) != -1) {
					fos.write(readData);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}
