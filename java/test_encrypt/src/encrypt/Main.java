package encrypt;

import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int input1 = Integer.parseInt(in.next());q
    int[][] arr = new int[input1][5];
    int[] arr2 = new int[input1];
    
    for(int i = 0; i < input1; i++) {
    	for(int j = 0; j<5; j++) {
    		arr[i][j] = Integer.parseInt(in.next());
    	}
    }
    
    int max = 0;
    int ptr = 0;
    
    for(int i = 0; i< input1; i++) {
    	int cnt = 0;
    	for(int j = 0; j<input1; j++) {
    		for(int k = 0; k<5; k++) {
    			if(arr[i][k] == arr[j][k]) {
    				cnt++;
    				break;
    			}
    		}
    	}
    	if(cnt > max) {
    		max = cnt;
    		ptr = i;
    	}
    }
    
    System.out.print(ptr+1);
    
    
    return;
  }
}

//if(x == '0' && sb.length() == 0) continue;
//else 