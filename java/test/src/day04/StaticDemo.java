package day04;

class Box {
	int cnt = 0;
	static long boxID = 0;

	public Box() {
		boxID = boxID + 1; // static variable
		cnt = cnt + 1; // member variable
		System.out.println("멤버 변수     cnt: " + cnt);
		System.out.println("static 변수 BoxID: " + boxID);

	}
	   
	  //멤버 메소드에서는 static변수를 선언할수 없습니다. 
	  /* 
	  public void staticTest(){ 
	      static long count=0; 
	      count=count+1; 
	       
	  } 
	  */ 
	   
	  //static(class) 메소드에 static 변수를 선언할 수 없습니다. 
	  /* 
	  public static void staticTest2(){ 
	      static long count=0; 
	      count=count+1; 
	       
	  } 
	  */ 
	   
	} 

	public class StaticDemo {
		public static void main(String args[]) {
			// 객체 생성
			Box mybox1 = new Box();
			Box mybox2 = new Box();
			Box mybox3 = new Box();
		}
	}
