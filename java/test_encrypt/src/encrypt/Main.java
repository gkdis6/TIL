package encrypt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static int n, m;
	static boolean visited[];
	static int[] answer;
	static ArrayList<Integer> A[];
	
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	A = new ArrayList[n+1];
    	answer = new int[n+1];
    	for(int i =1; i<=n; i++) {
    		A[i] = new ArrayList<Integer>();
    	}
    	for(int i = 0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int S = Integer.parseInt(st.nextToken());
    		int E = Integer.parseInt(st.nextToken());
    		A[S].add(E);
    	}
    	for(int i = 1; i<=n; i++) {
    		visited = new boolean[n+1];
    		BFS(i);
    	}
    	int maxVal = 0;
    	for (int i = 1; i<=n; i++) {
    		maxVal = Math.max(maxVal, answer[i]);
    	}
    	for(int i=1; i<=n; i++) {
    		if(answer[i] == maxVal) System.out.print(i + " ");
    	}
	}
	
	public static void BFS(int index) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(index);
		visited[index] = true;
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i : A[now]) {
				if(visited[i] == false) {
					visited[i] = true;
					answer[i]++;
					que.add(i);
				}
			}
		}
	}
}
