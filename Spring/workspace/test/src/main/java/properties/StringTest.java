package properties; 

public class StringTest { 

    public static void main(String[] args) { 
        String mapping = "/mvc/hello.do"; 
         
        // 'hello.do' 문자열의 추출 
        System.out.println(mapping); 
        System.out.println("-----------------------"); 
        System.out.print(mapping.charAt(0));   // '/' 
        System.out.print(mapping.charAt(1));   // 'm' 
        System.out.print(mapping.charAt(2));   // 'v' 
        System.out.println(mapping.charAt(3)); // 'c' 
        System.out.println("-----------------------");         
        System.out.println("mapping.substring(5): " + mapping.substring(5)); 
        System.out.println("-----------------------");         
         
        // 문자열이 '/mvc'로 시작하는지 검사하여 boolean값 리턴 
        System.out.println("startsWith: " + mapping.startsWith("/mvc")); 

        // 문자열이 '/mvc'로 끝나는지 검사하여 boolean값 리턴 
        System.out.println("endsWith: " + mapping.endsWith("/hello.do"));         
         
        // 마지막으로 "/"문자가 나타난 index 값 리턴 
        int index = mapping.lastIndexOf("/"); 
        System.out.println("index: " + index); 
         
        System.out.println("substring(index+1): " + mapping.substring(index+1)); 
         
        System.out.println("substring(0, 3): " + mapping.substring(0, 3));   
         
    } 
} 