package properties;


interface Action{
	void execute();
}

class Spring implements Action{
	@Override
	public void execute() {
		System.out.println("따스한 봄입니다. -새싹");
	}
}

class Summer implements Action{
	@Override
	public void execute() {
		System.out.println("더운 여름입니다. -바다");
	}
}

class Fall implements Action{
	@Override
	public void execute() {
		System.out.println("시원한 가을입니다. -등산");
	}
}

class Winter implements Action{
	@Override
	public void execute() {
		System.out.println("눈이 오는 겨울입니다. -X-MAS");
	}
}

public class ClassTest {

	public static void main(String[] args) {
		String className = args[0];//실행할 클래스명, 패키지 포함
		try {
			Class object = Class.forName(className);//JVM으로 소스 로딩
			Action instance = (Action)object.newInstance();//객체 생성
			instance.execute();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
