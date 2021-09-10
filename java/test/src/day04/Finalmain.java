package day04;

class Final{ 
    int money = 10000;  //인스턴스 변수          

    //값을 변경 할 수 없습니다. 
    final int day = 7;  //1주, final 인스턴스 변수 
    final int week = 4; //한달, final 인스턴스 변수 
     
    //객체를 만들지 않아도 사용할 수 있습니다. 
    //final static 변수 
    final static int month = 12; //1년 
     
    //생성자가 존재 하지만 아무런 처리를 하지 않습니다. 
    public Final(){}      
} 

public class Finalmain { 

    public static void main(String[] args) { 
        Final fi = new Final(); 
        fi.money = 15000; 
        //final변수는 값을 변경(대입)할 수 없습니다.  
        //fi.day = 10; 
        System.out.println("1주일 용돈:" + fi.money * fi.day); 
        System.out.println("1년" + Final.month + "달"); 
        //Final.month = 20000; 
    } 
} 