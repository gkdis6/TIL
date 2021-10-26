import socket, sys

# HOST = sys.argv[1]  # 'localhost'
HOST = 'localhost'
PORT = 9009

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:  # 자동 close
    sock.connect((HOST, PORT))  # 연결
    msg = input('메시지 입력: ')
    sock.sendall(msg.encode())  # 한글 -> 16진수 코드로 변환
    data = sock.recv(1024)  # 수신 대기, 1024 수신 용량 크기 byte

print('에코 서버로부터 받은 데이터 [%s]' % data.decode())