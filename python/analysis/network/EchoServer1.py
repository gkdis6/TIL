import socket

HOST = ''      # 서버임으로 생략
PORT = 9009

def runServer():
    # sock 객체 생성, 자동 close
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:
        sock.bind((HOST, PORT))  # 연결
        sock.listen(1)  # 최대 동시 연결 수 1

        while True:  # Client의 접속을 처리하는 무한 루틴
            print('접속 대기중...')
            conn, addr = sock.accept()  # client 접속 대기
            print(type(conn)) # <class 'socket.socket'>
            print(type(addr)) # <class 'tuple'>

            with conn: # 객체가 생성되었다면 True
                print('[%s]와 연결됨' % addr[0]) # ip
                while True:  # 데이터를 받기 위한 무한 루틴
                    data = conn.recv(1024)  # 1024 바이트 수신
                    if not data:
                        break;  # while 종료
                    print('메시지 수신 [%s]' % data.decode())  # 수신 데이터 출력, 한글 처리

                    conn.sendall(data)  # client에게 다시 전송, 전송 완료후 None 리턴
                    print('메시지 전송 [%s]' % data.decode())  # 전송된 데이터 출력, 한글 처리

runServer()