package day04;

public class DataAccess { 

    public static void main(String[] args) { 
        Data d = new Data(); 
        //d.name="왕눈이"; 
        //System.out.println(d.name); 
        d.setName("왕눈이"); 
        d.setSeason("늦가을"); 
        d.setYear(35); 
         
        System.out.println(d.getName()); 
        System.out.println(d.getSeason()); 
        System.out.println(d.getYear()); 

    } 
} 

