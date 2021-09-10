package chap04;

public class IntQueue {
	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] que;
	
	
	public class EmptyIntQueeueException extends RuntimeException {
		public EmptyIntQueeueException() { }
	}

	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() { }
	}
	
	public IntQueue(int max){
		this.max = max;
		num = front = rear = 0;
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
		
	}
	
	public int enque(int x) throws OverflowIntQueueException{
		if(num >= max)
			throw new OverflowIntQueueException();
		que[rear++] = x;
		num++;
		if(rear == max)
			rear = 0;
		return x;
	}
	
	public int deque() throws EmptyIntQueeueException{
		if(num <= 0)
			throw new EmptyIntQueeueException();
		int x = que[front++];
		num--;
		if(front == max)
			front = 0;
		return x;
	}
	
	public int peek() throws EmptyIntQueeueException{
		if(num <= 0)
			throw new EmptyIntQueeueException();
		return que[front];
	}
	
	public int indexOf(int x) {
		for(int i = 0; i< num; i++) {
			int idx = (i+ front) % max;
			if(que[idx]== x) 
				return idx;
		}
		return -1;
	}
	
	public int search(int x) {
		if(num <= 0)
			throw new EmptyIntQueeueException();
		for(int j = 0; j< num; j++) {
			int idx = (j+front)%max;
			if(que[idx] == x) {
				if((idx-front+1)>0)
					return idx-front;
				else
					return idx+max-front+1;
			}
		}
		return 0;
	}
	
	public void clear() {
		num = front = rear = 0;
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return num;
	}
	
	public boolean isEmpty() {
		return num<=0;
	}
	
	public boolean isFull() {
		return num >= max;
	}
	
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for(int i = 0; i< num; i++)
				System.out.print(que[(i+ front) % max] + " ");
			System.out.println();
		}
	}
}
