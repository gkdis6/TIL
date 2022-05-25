package encrypt;

import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int input1 = Integer.parseInt(in.next());
    int[][] arr = new int[input1][5];
    int[] arr2 = new int[input1];
    List list1 = null;
    
    for(int i = 0; i < input1; i++) {
    	List list = null;
    	for(int j = 0; j<5; j++) {
    		arr[i][j] = Integer.parseInt(in.next());
    		if(!list.contains(arr[i][j])) list.add(arr[i][j]);
    	}
    	for(int j = 0; j<5; j++) {
    		if(!list.contains(arr[i][j])) list.add(arr[i][j]);
    	}
    }
    
    for(int i = 0; i<5; i++) {
    	for(int j = 0; j<input1; j++) {
    		
    	}
    }
    
    
    return;
  }
}

//if(x == '0' && sb.length() == 0) continue;
//else 