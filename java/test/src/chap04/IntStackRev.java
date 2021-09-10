package chap04;

public class IntStackRev {
	private int max;
	private int ptrA;
	private int ptrB;
	private int[] stk;
	
	public enum AorB{
		StackA, StackB
	};
	
	public class EmptyIntStaackException extends RuntimeException{
		public EmptyIntStaackException() {}
	}
	
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	
	public IntStackRev(int capacity) {
		ptrA = 0;
		ptrB = capacity-1;
		max = capacity;
		try {
			stk = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int push(AorB sw, int x) throws OverflowIntStackException{
		if(ptrA >= ptrB +1)
			throw new OverflowIntStackException();
		switch(sw) {
		case StackA:
			stk[ptrA++] = x;
			break;
		case StackB:
			stk[ptrB--] = x;
			break;
		}
		return x;
	}
	
	public int pop(AorB sw) throws EmptyIntStaackException{
		int x = 0;
		switch(sw) {
		case StackA:
			if(ptrA <= 0)
				throw new EmptyIntStaackException();
			x = stk[--ptrA];
			break;
		case StackB:
			if(ptrB >= max-1)
				throw new EmptyIntStaackException();
			x = stk[++ptrB];
			break;
		}
		return x;
	}
	
	public int peek(AorB sw) throws EmptyIntStaackException{
		int x = 0;
		switch(sw) {
		case StackA:
			if(ptrA <= 0)
				throw new EmptyIntStaackException();
			x = stk[ptrA - 1];
			break;
		case StackB:
			if(ptrB >= max-1)
				throw new EmptyIntStaackException();
			x = stk[ptrB + 1];
			break;
		}
		return x;
		
	}
	
	public int indexOf(AorB sw, int x) {
		switch(sw) {
		case StackA:
			for(int i = ptrA -1; i>= 0; i--)
				if(stk[i] == x)
					return i;
			break;
		case StackB:
			for(int i = ptrB+1; i<=max; i++)
				if(stk[i] == x)
					return i;
			break;
		}
		return -1;
	}
	
	public void clear(AorB sw) {
		switch (sw) {
		case StackA:
			ptrA = 0;
			break;
		case StackB :
			ptrB = max-1;
			break;
		}
	}
	
	public int capacity() {
		return max;
	}
	
	public int size(AorB sw) {
		switch (sw) {
		case StackA:
			return ptrA;
		case StackB:
			return max - ptrB -1;
		}
		return 0;
	}
	
	public boolean isEmpty(AorB sw) {
		switch (sw) {
		case StackA:
			return ptrA <= 0;
		case StackB:
			return ptrB >= max-1;
		}
		return true;
	}
	
	public boolean isFull() {
		return ptrA>=ptrB +1;
	}
	
	public void dump(AorB sw) {
		switch (sw) {
		case StackA:
			if (ptrA <= 0)
				System.out.println("스택이 비었습니다.");
			else {
				for (int i = 0; i < ptrA; i++)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		case StackB:
			if (ptrB >= max - 1)
				System.out.println("스택이 비었습니다.");
			else {
				for (int i = max - 1; i > ptrB; i--)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		}
	}
}
