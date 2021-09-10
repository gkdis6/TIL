package day02;

public class IncDec { 

    public static void main(String[] args) { 
        long i = 0; 
        long hap = 0; 
         
        hap = ++i; // i 변수의 값을 1증가시켜 hap에 할당, 전치 증가 연산자 
        //hap = i; 
        hap = i++; // hap에 i변수의 값을 주고 i 변수의 값을 1증가, 후치 증가 연산자 
        //i++; // ++i  //i = i+1; 
        //hap = i; 
        //hap = ++hap + ++i; //권장 아님 
        System.out.println("hap: " + hap + "     i: " + i); 
         

    } 

} 