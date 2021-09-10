package test;

import java.io.BufferedReader;
import java.io.IOException;

public class CharIOExam01 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(line);
	}

}
