package chap06;

public class BubbleSort2 {
	
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void bubbleSort(int[] a) {
		int n = a.length;
		for(int i = 0; i<n-1; i++) {
			int exch = 0;
			for(int j = n-1; j>i; j--) {
				if(a[j-1] > a[j]) {
					swap(a, j-1, j);
					exch++;
				}
			}
			if(exch == 0) break;
		}
	}
	//연습문제 3은 BubbleSort에 작성되어 있

	public static void main(String[] args) {

	}

}
