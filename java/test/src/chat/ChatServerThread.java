package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServerThread {

	private Socket socket = null;
	private ServerSocket server = null;

	public void serverStart() {
		System.out.println("접속자를 기다리는 중입니다.");
		try {
			server = new ServerSocket(2007);
			socket = server.accept();

			InetAddress ia = socket.getInetAddress();
			int port = socket.getLocalPort();// 접속에 사용된 PORT
			String ip = ia.getHostAddress(); // 원격 Client IP

			System.out.print("클라이언트 접속-Local Port: " + port);
			System.out.println(" Client IP: " + ip);

			// 데이터를 읽어오는 스레드
			ChatServerReadHandler read = new ChatServerReadHandler(socket);
			read.start();
			// 데이터를 보내는 스레드
			ChatServerSendHandler send = new ChatServerSendHandler(socket);
			send.start();
		} catch (IOException ioe) {
			System.err.println("연결이 되어 있지 않습니다.");
		} finally {
			try {
				server.close();
			} catch (IOException ignored) {
			}
		}

	}

	public static void main(String[] args) {
		ChatServerThread cs = new ChatServerThread();
		cs.serverStart();
	}
}

/**
 * 데이터를 읽어옵니다.
 * 
 * @author stu
 * 
 */
class ChatServerReadHandler extends Thread {
	private Socket socket;
	private String line; // 서버로부터 읽어온 문자열 저장

	public ChatServerReadHandler() {
		System.out.println("프로그램이 초기화 되지 않았습니다.");
	}

	public ChatServerReadHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				line = reader.readLine();

				if (line == null) {
					break;
				}
				System.out.println("받은글: " + line);
				System.out.print("☞ ");
			}

		} catch (IOException ignored) {
		} finally {
			try {
				socket.close();
			} catch (IOException ignored) {
			}
		}
	}

}

/**
 * 데이터를 보냅니다.
 * 
 * @author stu
 * 
 */
class ChatServerSendHandler extends Thread {
	private Socket socket;
	private BufferedWriter writer;
	private BufferedReader in;
	private String s = "";

	public ChatServerSendHandler() {
		System.out.println("프로그램이 초기화 되지 않았습니다.");
	}

	public ChatServerSendHandler(Socket socket) {
		this.socket = socket;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			System.err.println("연결이 되어 있지 않습니다.");
		}
	}

	public void run() {
		try {
			while (true) {
				System.out.print("☞ ");
				s = in.readLine(); // 키보드로부터 입력
				if (s.equals("999")) {
					break; // 종료코드
				}
				writer.write(s);
				writer.newLine(); // 줄바뀜 기호가 있어야 BufferedReader의 readLine()이 인식함
				writer.flush(); // client로 전송

				// System.out.println("보낸 글:" + s);//입력받은 내용 출력
			}
		} catch (Exception ignored) {

		} finally {
			try {
				socket.close();
			} catch (IOException ignored) {
			}
		}
	}

}
