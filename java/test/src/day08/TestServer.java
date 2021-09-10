package day08;

import java.io.*;
import java.net.*;

public class TestServer {
	public static void main(String[] args) {
		System.out.println("***** 개발자_1 서버 프로그램 작동됨 *****");
		ServerSocket server = null;
		try {
			// 2007 포트로 ServerSocket 생성
			server = new ServerSocket(2007);
			while (true) { // 데몬이 되기 위한 무한 루프
				System.out.println("클라이언트 접속을 대기중입니다.");
				Socket client = server.accept(); // Lock

				InetAddress ia = client.getInetAddress();
				int port = client.getLocalPort();// 접속에 사용된 PORT
				String ip = ia.getHostAddress(); // 원격 Client IP
				System.out.println("클라이언트 접속:" + " Local Port: " + port + " IP: " + ip);
				// 한글을 출력할 수 있습니다.
				// Client로 출력할 객체 생성
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

				// 버퍼에 문자열을 기록함
				writer.write("개발자_1 서버에 접속 하신것을 환영 합니다.");

				// 실제로 Client로 전송함
				writer.flush();
				try {
					client.close(); // 소켓 닫음
				} catch (IOException e) {
					System.out.println("Socket을 닫는중 에러 났습니다." + e.toString());
				}
			}
		} catch (IOException ioe) {
			System.err.println("Exception generated...");
		} finally {
			try {
				server.close();
				System.out.println("서버 작동을 종료합니다.");
			} catch (IOException e) {
				System.out.println("ServerSocket을 닫는중 에러 났습니다." + e.toString());
			}
		}
		// 아무키나 누를 때까지 대기합니다.
		try {
			InputStream is = System.in;
			is.read();
		} catch (Exception e) {

		}
		System.out.println("서버 프로그램 실행을 종료합니다.");
	}
}