package day01;

public class Ex03_01 {

  public static void main(String[] args) {
    System.out.printf("%d\n", 123);
    System.out.printf("%5d\n", 123);
    System.out.printf("%05d\n", 123);

    System.out.printf("%f\n", 123.45);
    System.out.printf("%7.1f\n", 123.45);
    System.out.printf("%7.3f\n", 123.45);

    System.out.printf("%s\n", "Hi~Java");
    System.out.printf("%10s\n", "Hi~Java");
    
    System.out.printf("\n줄바꿈\n연습 \n");
    System.out.printf("\t탭키\t연습 \n");
    System.out.printf("이것을\r덮어씁니다 \n");
    System.out.printf("글자가 \"강조\"되는 효과 \n");
    System.out.printf("\\\\\\ 역슬래시 세개 출력 \n");
  }
}
