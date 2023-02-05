package encrypt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.UUID;

public class Main_programers{
	
    public static void main(String[] args) throws IOException{
    	int n = 6;
    	int[] times = {3,1,2};
    	String s = "ababcdcdababcdcd";
    	System.out.println(problem(s));
    	
    	
		return;
    }
    
    public static int problem(String s) {
    	char[] c = s.toCharArray();
    	for(int i = 0; i<c.length-1; i++) {
    		String cs = s.substring(0, i) + s.substring(i, i+2);
    	}
    	return 1;
    }
    
    
    
}
