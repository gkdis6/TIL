import socket, sys

#HOST = sys.argv[1]  # 'localhost'
HOST = 'localhost'
PORT = 9009

if HOST != '':
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:  # 자동 close
        sock.connect((HOST, PORT))  # 연결
        data = sock.recv(1024)  # 수신 대기

    values = data.decode().split('/')
    print(type(values))  # <class 'list'>

    count = len(values) # 배열의 길이
    print('len(values): ' + str(count))  # 4
    print('▷ ' + values[0])  # 추천 분야
    print('-----------------------------')
    for index in range(1, count):  # 추천 항목, 0: 제목, 1~
        print(values[index])

else:
    print('사용법: python ExamClient1.py ')