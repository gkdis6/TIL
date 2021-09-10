
public class FirstMethod {

	public static void main(String[] args) {

		hello_method();
		hello_method();
		hello_method();
		hello_method();
		
		hello_method();
		hello_method();
		hello_method();
		
		printTwoTimes("B");
		printTwoTimesDeli("A","=");
						  //인자, argument
		
		System.out.println(twoTimes2("ㄹㅁㄷ", "ㅁㄴㄹㅇ"));
		
	}

	public static void hello_method() {
		System.out.println("Hello Method");
		System.out.println(Math.floor(1.1));
	}
	
	public static void printTwoTimes(String text) {
		System.out.println("-");
		System.out.println(text);
		System.out.println(text);
	}
										 //매개변수,parameter
	public static void printTwoTimesDeli(String text, String delimiter) {
		System.out.println(delimiter);
		System.out.println(text);
		System.out.println(text);
	}
	
	public static String twoTimes2(String text, String delimiter) {
		String out = "";
		out = out + delimiter + "\n";
		out = out + text + "\n";
		out = out + text + "\n";
		return out;
	}
}
