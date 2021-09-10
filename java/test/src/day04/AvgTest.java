package day04;

public class AvgTest { 

    public int getAvg(){ 
        System.out.println("값을 2개이상 입력해 주세요."); 
        return 0; 
    } 
     
//    public int getAvg(int a, int b){ 
//        return (a + b) / 2; 
//    } 
     
    public int getAvg(float a, float b){ 
        return ((int)a+(int)b)/2; 
    } 

    public int getAvg(int a, int b, int c){ 
        return (a + b + c) / 3; 
    } 

    public int getAvg(int a, int b, int c, int d){ 
        return (a + b + c + d) / 4; 
    } 

//    리턴 타입은 메소드 구분을 할 수 없습니다.     
//    public float getAvg(){ 
//        return 0.0f; 
//    } 
     
    public static void main(String[] args) { 
        AvgTest st = new AvgTest(); 
        System.out.println(st.getAvg()); 
        System.out.println(st.getAvg(10,20)); //자동형변환으로 float으로 가서 처리
        System.out.println(st.getAvg(10.5f,20.5f)); 
        System.out.println(st.getAvg(10,20,30)); 
        System.out.println(st.getAvg(10,20,30,40)); 
         
    } 

} 