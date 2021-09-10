package corejava; 

public class Star { 
    public String show(){ 
        return "★☆★☆★☆★☆★☆"; 

    } 

    public static void main(String[] args){ 
        Star star = new Star(); 
        System.out.println(star.show()); 
    } 
} 