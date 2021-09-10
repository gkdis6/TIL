package day02;

public class Bitwise { 
    public static void main(String args[]) { 
      int a = 2; 
      int b = 5; 
       
      int c = a | b; //2진수 bit or 
     
      //   ....8421  ----->가중치 
      // 00000010 
      //+00000101 
      //---------   
      // 00000111--> 7 
       
      int d = a & b; //and 
      // 00000010 
      //+00000101 
      //---------   
      // 00000000--> 0 
       
       
      int e = a ^ b; //Exclusive or 
      // 00000010 
      //+00000101 
      //---------   
      // 00000111--> 7 
       
       
      int i; int j; 
      i = a << 2;    //좌 shift 연산, 2를 2번 곱합 
      // ....8421   
    // 00000010 
      // 00001000 --> 8 
       
       
      j = b >> 2;    //우 shift 연산. 2로 2번 나눔  
      // ....8421   
        // 00000101 
      // 00000001 --> 1 
       

      System.out.println("        a = " + a); 
      System.out.println("        b = " + b); 
      System.out.println("      a|b = " + c); 
      System.out.println("      a&b = " + d); 
      System.out.println("      a^b = " + e); 
      System.out.println("     a<<2 = " + i); 
      System.out.println("     b>>2 = " + j); 
      
  } 
} 


