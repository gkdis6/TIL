package encrypt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int a = Integer.parseInt(br.readLine());
		int b = 1;
		int c = 1;
		while(a/b>=1) {
			b = b*10;
			c++;
		}
        System.out.println(b);
        System.out.println(c);
        
	}
}