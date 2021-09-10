package day06;

import java.io.File; 
import java.io.FileReader; 
import java.io.FileWriter; 

public class CopyFile{ 
    public static void main(String[] args) { 
        try{ 
             //파라미터를 2개를 받았는지 검사 
            if (args.length != 2) { 
                System.out.println ("---------------- 에러 발생 ----------------"); 
                System.out.println ("usage: java CopyFile <원본파일명> <대상파일명>"); 
                 
                //비 정상적인 종료: 0보다 큰값을 지정 
                System.exit (1);  //프로그램 종료 
            }         
             
            //파일 객체 생성 
            File inputFile = new File(args[0]);//소스파일명 
            File outputFile = new File(args[1]);//생성될 파일명 
             
            // FileReader는 데이터를 읽어오는 역활을 합니다. 
            FileReader in = new FileReader(inputFile); 
             
            // FileWriter는 쓰는 역활을 합니다. 
            FileWriter out = new FileWriter(outputFile); 
         
            int c; 
             
            // 숫자형태로 변경되어 처리됩니다. 
            // EOF -1 
            while ((c = in.read()) != -1){ 
                //파일에 출력 
                out.write(c); 
            } 
                     
            System.out.println("파일 복사가 완료되었습니다."); 
            //스트림을 닫아줍니다. 
            in.close(); 
            out.close(); 
             
        }catch(Exception e){ 
            System.out.println(e.toString()); 
        } 
    } 
} 