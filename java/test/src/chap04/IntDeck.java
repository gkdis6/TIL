package chap04;

import chap04.IntQueue.OverflowIntQueueException;
import chap04.IntStackRev.EmptyIntStaackException;

public class IntDeck {
	private int max;
	private int num;
	private int front;
	private int rear;
	private int[] d;
	
	public enum AorB{
		A, B
	};
	
	public class EmptyIntDeckException extends RuntimeException{
		public EmptyIntDeckException() {}
	}
	
	public class OverflowIntDeckException extends RuntimeException{
		public OverflowIntDeckException() {}
	}
	
	public IntDeck(int capacity){
		num = front = rear = 0;
		this.max = capacity;
		try {
			d = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int enque(AorB sw, int x) throws OverflowIntDeckException{
		if(num >= max)
			throw new OverflowIntDeckException();
		switch (sw) {
		case A:
			d[rear++] = x;
			if(rear>=max)
				rear = 0;
			break;
		case B:
			d[front--] = x;
			if(front < 0)
				front = max-1;
			break;
		}
		return x;
	}
	
	public int deque(AorB sw) throws EmptyIntDeckException{
		if(num <= 0)
			throw new EmptyIntDeckException();
		int x= 0;
		switch (sw) {
		case A:
			x = d[front++];
			num--;
			if(front>=max)
				front = 0;
			break;
			
		case B:
			x = d[rear--];
			num--;
			if(rear < 0)
				rear = max-1;
			break;
		}
		return x;
	}
	
	public int peek(AorB sw) throws EmptyIntDeckException{
		int x = 0;
		if(num <= 0)
			throw new EmptyIntDeckException();
		else {
			switch(sw) {
			case A:
				x = d[front];
				break;
			case B:
				x = d[rear];
				break;
			}
		return x;
		}
	}
}
