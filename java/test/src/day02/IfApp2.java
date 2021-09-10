package day02;

public class IfApp2{ 
    public static void main(String args[]){ 
        int k=90; 

        //논리 and 연산자  
        if(k % 3 == 0 && k % 5 == 0){ 
            System.out.println("k의 값은:" + k + ": 3의 배수이면서 5의 배수입니다."); 
        } 
        else{ 
            System.out.println("K의 값은 3의 배수이면서 5의 배수가 아닙니다."); 
        } 
    } 
} 