package day05;

class TypeConvert{
	String url = "https://www.kma.go.kr";
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	@Override
	public String toString() {
		return "자식 클래스에서 메소드 오버라이딩";
	}
	
}

public class TypeConvertTest {

	public static void main(String[] args) {
		TypeConvert tc = new TypeConvert();
		Object obj = tc; //업캐스팅
		//System.out.println(obj.getUrl());
		System.out.println(tc.getUrl());
		
		System.out.println(obj.hashCode());
		System.out.println(tc.hashCode());
		
		TypeConvert tc2 = (TypeConvert)obj;
		System.out.println(tc2.getUrl());
		System.out.println(tc2.hashCode());
		
		System.out.println(tc);
		System.out.println(obj);
		System.out.println(tc2);
	}

}
