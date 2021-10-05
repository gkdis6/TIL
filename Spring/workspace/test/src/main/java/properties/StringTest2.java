package properties; 

public class StringTest2 { 

    public static void main(String[] args) { 
         
        String str = "mail@domain.com"; 
     
        pl("ⓐ '@'문자가 있는지의 여부를 출력하는 루틴 제작"); 
        pl(str.indexOf('@'));      // 4 
        pl(str.indexOf('X'));      // 존재하지 않음으로 -1 
        pl(str.indexOf("domain")); // domain 문자열의 시작위치 5 
        pl(str.indexOf('.'));      // 11 
        pl(str.length());          // 15 
        pl(str.replaceAll("domain", "www.java")); // mail@www.java.com 

        for(int i=0; i < str.length(); i++){ 
            p(str.charAt(i)); 
        } 

    } 
     
    public static void pl(String str){ 
        System.out.println(str); 
    } 

    public static void pl(int i){ 
        System.out.println(i); 
    } 
     
    public static void p(char i){ 
        System.out.print(i); 
    }     
} 