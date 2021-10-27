import socket

HOST = ''
PORT = 9009

def runServer():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:  # 자동 close
        sock.bind((HOST, PORT))  # 연결
        sock.listen(1)  # 최대 동시 연결 수

        while True:
            print('접속 대기중...')
            conn, addr = sock.accept()  # 접속 대기

            with conn: # 객체가 생성되었다면 True
                print('[%s]와 연결됨' % addr[0])
                # client에게 전송, 전송 완료후 None 리턴
                conn.sendall('영화 추천/이미테이션 게임/월터의 상상은 현실이된다./악마는 프라다를 입는다.'.encode())

runServer()
