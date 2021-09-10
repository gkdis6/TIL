package day04;

public class Sungjuk {
	 
	  public static void main(String[] args) {
	    int[] jumsu = new int[4];
	    int tot = 0;
	    int avg = 0;
	    String grade = "";
	    
	    java.util.Scanner in = new java.util.Scanner(System.in);
	    
	    System.out.print("국어점수를 입력하세요: ");
	    jumsu[0] = in.nextInt();  // 정수 입력
	    
	    System.out.print("영어점수를 입력하세요: ");
	    jumsu[1] = in.nextInt();  // 정수 입력
	 
	    System.out.print("수학점수를 입력하세요: ");
	    jumsu[2] = in.nextInt();  // 정수 입력
	 
	    System.out.print("전산점수를 입력하세요: ");
	    jumsu[3] = in.nextInt();  // 정수 입력
	    
	    tot = jumsu[0] + jumsu[1] + jumsu[2] + jumsu[3];
	    avg = tot/4;
	    
	    if (avg >= 90 && avg <= 100){
	      grade = "A";
	    }else if (avg >= 80 && avg <= 89){
	      grade = "B";
	    }else if (avg >= 70 && avg <= 79){
	      grade = "C";
	    }else if (avg >= 60 && avg <= 69){
	      grade = "D";
	    }else{
	      grade = "F";
	    } 
	 
	    System.out.println("------------------------------");
	    System.out.println("         성적 내역서");
	    System.out.println("------------------------------");
	 
	    System.out.print("국어:");
	    
	    int _kuk = jumsu[0] / 10;
	    for(int i=1; i<= _kuk; i++){
	      System.out.print("*");
	    }
	    System.out.println(" " + jumsu[0]);
	    
	    System.out.print("영어:");
	    
	    int _eng = jumsu[1] / 10;
	    for(int i=1; i<= _eng; i++){
	      System.out.print("*");
	    }
	    System.out.println(" " + jumsu[1]);
	 
	    System.out.print("수학:");
	    
	    int _mat = jumsu[2] / 10;
	    for(int i=1; i<= _mat; i++){
	      System.out.print("*");
	    }
	    System.out.println(" " + jumsu[2]);
	 
	    System.out.print("전산:");
	    
	    int _com = jumsu[3] / 10;
	    for(int i=1; i<= _com; i++){
	      System.out.print("*");
	    }
	    System.out.println(" " + jumsu[3]);
	    
	    System.out.print("총점: " + tot);
	    System.out.print("  평균: " + avg);
	    System.out.println("  등급: " + grade);
	    System.out.println("------------------------------");
	    
	    
	  }
	 
	}
