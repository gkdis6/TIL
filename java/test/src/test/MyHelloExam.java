package test;

import java.lang.reflect.Method;

public class MyHelloExam {

	public static void main(String[] args) {
		MyHello hello = new MyHello();
		
		try {
			Method method = hello.getClass().getDeclaredMethod("hello");
			
			if(method.isAnnotationPresent(Count100.class)) {//Count100이라는 어노테이션을 가지고 있으면 실행
				for(int i = 0; i<100; i++) {
					hello.hello();
				}
			}else {
				hello.hello();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

}
