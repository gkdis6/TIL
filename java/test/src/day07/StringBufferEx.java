package day07;

public class StringBufferEx {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("This");
		System.out.println(sb.hashCode()); // 생성 후 스트링버퍼 해쉬값 출력
		sb.append(" is pencil"); // 문자열 덧붙이기
		System.out.println(sb);
		sb.insert(7, " my"); // 문자열 삽입
		System.out.println(sb);
		sb.replace(8, 10, "your"); // 문자열 대치
		System.out.println(sb);
		sb.setLength(5); // 스트링 버퍼 내 문자열 길이 설정
		System.out.println(sb);
		System.out.println(sb.hashCode()); // 문자열 조작 후 스트링 버퍼의 해쉬 코드
											// 값이 같으면 같은 객체임을 나타낸다.
	}
}