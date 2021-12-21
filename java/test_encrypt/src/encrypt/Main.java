package encrypt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int a = Integer.parseInt(br.readLine());
        
        sb.append((int) (Math.pow(2, a)-1)).append("\n");
        
        hanoi(a, 1, 2, 3);
        
        System.out.print(sb);
        
	}
	public static void hanoi(int n, int start, int mid, int end) {
		if(n == 1) {
			sb.append(start+" "+end+"\n");
			return;
		}
		hanoi(n-1, start, end, mid);
		
		sb.append(start+" "+end+"\n");
		
		hanoi(n-1, mid, start, end);
	}
}