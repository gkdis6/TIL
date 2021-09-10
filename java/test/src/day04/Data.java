package day04;

public class Data{ 
    //인스턴스 변수, 멤버 변수 
    private String name=null; 
    private String season=null; 
    private int year = 0; 
     
    //set으로 시작하는 메소드는 setter라고 부릅니다. 
    //set은 소문자로, 연결되는 변수명의 첫자는 대문자를 사용합니다. 
    //private변수에 값을 대입하는 목적을 가지고 있습니다. 
    //값을 저장함으로 리턴타입은 void를 이용합니다. 
    public void setName(String name){ 
        this.name = name; 
    } 
     
    public void setSeason(String season){ 
        this.season = season; 
    } 
     
    public void setYear(int year){ 
        if (year >= 20 && year <= 30){ 
            this.year = year;  
        }else{ 
            System.out.println("입력될 수 있는 나이는 20~30세 사이입니다."); 
        } 
         
    } 
     
    //get으로 시작하는 메소드는 getter라고 부릅니다. 
    //get은 소문자로, 연결되는 변수명의 첫자는 대문자를 사용합니다. 
    //private변수에서 값을 가져오는 목적을 가지고 있습니다. 
    //값을 가져옴으로 값에 따른 다양한 데이터타입을 지정합니다. 
    public String getName(){ 
        return name; 
    } 
     
    public String getSeason(){ 
        return season; 
    } 
     
    public int getYear(){ 
        return year; 
    } 
         
} 
