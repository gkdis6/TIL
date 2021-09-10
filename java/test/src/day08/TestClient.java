package day08;

import java.io.*;
import java.net.*;

public class TestClient {
	public static void main(String[] args) {
		System.out.println("클라이언트 프로그램 작동.....");

		Socket socket = null;
		try {
			// args[0]: 접속할 지역의 IP
			// 2007: 접속할 Server Port
			socket = new Socket(args[0], 2007);

			System.out.println("서버에 연결 되었습니다....");

			InetAddress ia = socket.getInetAddress();
			int port = socket.getLocalPort();// 접속에 사용된 PORT
			String ip = ia.getHostAddress(); // 원격 Client IP

			System.out.println("접속한 서버 정보:" + " Local Port: " + port + " IP: " + ip);
			// 서버로부터 데이터를 입력받아 버퍼에 저장합니다.
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 버퍼로부터 한 라인씩 읽어 출력합니다.
			// Blocking상태에서 기다립니다.
			String line = reader.readLine();
			System.out.println(line);
		} catch (IOException ioe) {
			System.err.println("Exception generated...");
		} finally {
			try {
				socket.close();
				System.out.println("서버와의 접속을 종료합니다.");
			} catch (Exception ignored) {
			}
		}
		// 아무키나 누를 때까지 대기합니다.
		InputStream is = System.in;
		try {
			is.read();
		} catch (Exception e) {

		}
		System.out.println("Client 프로그램 실행을 종료합니다.");
	}
}
