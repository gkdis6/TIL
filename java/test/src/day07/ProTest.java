package day07;

//import java.util.Properties; 

public class ProTest {
	
	public static void main(String[] args) {
		// Properties p = new Properties();
		java.util.Properties p = new java.util.Properties();
		p.put("step1", "JAVA + SCJP");
		p.put("step2", "JSP + Oracle + SCWCD");
		p.put("step3", "EJB + SCBCD");
		p.put("step4", "OJT + MVC2, Framework + 개발");
		System.out.println("STEP1:" + p.getProperty("step1"));
		System.out.println("STEP2:" + p.getProperty("step2"));
		System.out.println("STEP3:" + p.getProperty("step3"));
		System.out.println("STEP4:" + p.getProperty("step4"));
	}

}