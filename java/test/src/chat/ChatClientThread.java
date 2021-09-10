package chat; 
 
import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.OutputStreamWriter; 
import java.net.InetAddress; 
import java.net.Socket; 
 
public class ChatClientThread { 
    private Socket socket = null; 
     
    public void clientStart(String ip){ 
        System.out.println("클라이언트 프로그램 작동....."); 
        try { 
            socket = new Socket(ip, 2007); 
             
            InetAddress ia = socket.getInetAddress(); 
            int local_port = socket.getLocalPort();// 접속에 사용된 PORT 
            int server_port = socket.getPort();// 접속에 사용된 PORT 
            String server_ip = ia.getHostAddress(); // 원격 Client IP  
             
            System.out.print("클라이언트 접속-Local Port: "+ local_port); 
            System.out.print(" Server IP: " + server_ip); 
            System.out.println(" Server PORT: " + server_port);             
             
            //데이터를 읽어오는 스레드 
            ChatClientReadHandler read = new ChatClientReadHandler(socket); 
            read.start(); 
            //데이터를 보내는 스레드 
            ChatClientSendHandler send = new ChatClientSendHandler(socket); 
            send.start(); 
             
        } catch(IOException ioe) { 
            System.err.println("연결이 되어 있지 않습니다."); 
        } finally { 
            try { 
                if(socket == null){ 
                    socket.close();                     
                } 
            } catch(IOException ignored) {} 
        } 
        
    } 
 
    public static void main(String[] args) { 
        ChatClientThread cc = new ChatClientThread(); 
        cc.clientStart(args[0]); 
    } 
} 
 
/** 
 * 데이터를 읽어옵니다. 
 * @author stu 
 * 
 */ 
class ChatClientReadHandler extends Thread{ 
    private Socket socket; 
    private String line;   //서버로부터 읽어온 문자열 저장     
 
    public ChatClientReadHandler() { 
        System.out.println("프로그램이 초기화 되지 않았습니다."); 
    } 
     
    public ChatClientReadHandler(Socket socket) { 
        this.socket = socket;   
    } 
 
    public void run() { 
        try { 
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
            while(true){ 
                line = reader.readLine(); 
                 
                if (line == null){  
                    break; 
                } 
                 
                System.out.println("받은글: " + line); 
                System.out.print("☞ "); 
            } 
        } catch(IOException ignored) { 
            System.err.println("연결이 되어 있지 않습니다."); 
        } finally { 
            try { 
                socket.close(); 
            } catch(IOException ignored) {} 
        } 
    } 
 
} 
 
/** 
 * 데이터를 보냅니다. 
 * @author stu 
 * 
 */ 
class ChatClientSendHandler extends Thread{ 
    private Socket socket; 
    private BufferedWriter writer; 
    private BufferedReader in;            
    private String s=""; 
 
    public ChatClientSendHandler() { 
        System.out.println("프로그램이 초기화 되지 않았습니다."); 
    } 
     
    public ChatClientSendHandler(Socket socket) { 
        this.socket = socket; 
        try{ 
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 
            in = new BufferedReader(new InputStreamReader(System.in)); 
        } catch (Exception e) { 
            System.err.println("연결이 되어 있지 않습니다."); 
        }    
    } 
 
    public void run() { 
        try { 
            while(true) { 
                System.out.print("☞ "); 
                s = in.readLine(); //키보드로부터 입력 
                if(s.equals("999")){ 
                    break; //종료코드 
                } 
                writer.write(s); 
                writer.newLine();  //줄바뀜 기호가 있어야 BufferedReader의 readLine()이 인식함 
                writer.flush(); 
                //System.out.println("보낸 글:" + s);//입력받은 내용 출력 
            } 
        } catch(Exception ignored) { 
 
        } finally { 
            try { 
                socket.close(); 
            } catch(IOException ignored) {} 
        } 
    } 
 
} 