package day01;

public class Hello2 {

  public static void main(String[] args) {
    int i = 20;
    char a;
    
    int s = sum(i,10);
    a = '?';
    System.out.println(a);
    System.out.println("Hello2");
    System.out.println(s);

  }
  
  public static int sum(int n, int m) {
    return n+m;
  }

}
