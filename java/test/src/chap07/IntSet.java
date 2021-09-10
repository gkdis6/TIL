package chap07;

public class IntSet {

	private int max;
	private int num;
	private int[] set;
	
	public IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max];
		}catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return num;
	}
	
	public int indexOf(int n) {
		for(int i = 0; i<num; i++)
			if(set[i] == n)
				return i;
		return -1;
	}
	
	public boolean contains(int n) {
		return (indexOf(n) != -1)? true : false;
		
	}
	
	public boolean add(int n) {
		int idx;
		if(num >= max || (idx = indexOf(n)) >= 0)
			return false;
		else {
			num++;
			for(int i = num-1; i>idx+1; i--)
				set[i] = set[i-1];
			set[num++] = n;
			return true;
		}
	}
	
	public boolean add(IntSet s) {
		boolean flag = false;
		
		for(int i = 0; i<s.num; i++)
			if(add(s.set[i]) == true)
				flag = true;
		return flag;
	}
	
	public boolean retain(IntSet s) {
		boolean flag = false;
		
		for(int i = 0; i<num; i++)
			if(s.contains(set[i]) == false) {
				remove(set[i]);
				flag = true;
			}
		return flag;
	}
	
	public boolean remove(int n) {
		int idx;
		
		if(num <= 0 || (idx=indexOf(n)) == -1)
			return false;
		else {
			set[idx] = set[--num];
			return true;
		}
	}
	
	public boolean remove(IntSet s) {
		boolean flag = false;
		
		for(int i = 0; i<num; i++)
			if(s.contains(set[i]) == true) {
				remove(set[i]);
				flag = true;
			}
		return flag;
	}
	
	public void copyTo(IntSet s) {
		int n = (s.max < num) ? s.max : num;
		for(int i = 0; i<n; i++)
			s.set[i] = set[i];
		s.num = n;
	}
	
	public void copyFrom(IntSet s) {
		int n = (max < s.num) ? max : s.num;
		for(int i = 0; i<n; i++)
			set[i] = s.set[i];
		num = n;
	}
	
	public boolean equalTo(IntSet s) {
		if(num != s.num)
			return false;
		
		for(int i = 0; i<num; i++) {
			int j = 0;
			for(; j<s.num; j++)
				if(set[i] == s.set[j])
					break;
			if(j == s.num)
				return false;
		}
		return true;
	}
	
	public void unionOf(IntSet s1, IntSet s2) {
		copyFrom(s1);
		for(int i = 0; i<s2.num; i++)
			add(s2.set[i]);
	}
	
	public String toString() {
		StringBuffer temp = new StringBuffer("[ ");
		for(int i =0; i< num; i++)
			temp.append(set[i]+" ");
		temp.append("]");
		return temp.toString();
	}
	
	public boolean isEmpty() {
		if(num == 0) return true;
		return false;
	}
	
	public boolean isFull() {
		if(num == max) return true;
		return false;
	}
	
	public void clear() {
		num = 0;
	}
	
	public boolean isSubsetOf(IntSet s) {
		if(equalTo(s) == true) return true;
		for(int i = 0; i<num; i++)
			if(s.contains(set[i]) == false) return false;
		return true;
	}
	
	public boolean isProperSubsetOf(IntSet s) {
		if(equalTo(s) == true) return false;
		for(int i = 0; i<num; i++)
			if(s.contains(set[i]) == false) return false;
		return true;	
	}
	
	public void intersectionOf(IntSet s1, IntSet s2) {
		clear();
		for(int i = 0; i<s1.num; i++)
			if(s2.contains(s1.set[i])) add(s1.set[i]);
	}
	
	public void differenceOf(IntSet s1, IntSet s2) {
		clear();
		for(int i = 0; i<s1.num; i++)
			if(!s2.contains(s1.set[i])) add(s1.set[i]);
	}
	
}
