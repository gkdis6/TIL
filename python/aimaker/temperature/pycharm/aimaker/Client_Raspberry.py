import socket, sys
from time import sleep
import random as rnd
#HOST = sys.argv[1]  # 'localhost'
HOST = '127.0.0.1'
PORT = 9009
# python Client_Raspberry.py
if HOST != '':
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:  # 자동 close
        sock.connect((HOST, PORT))  # 연결
        with sock:  # 객체가 생성되었다면 True
            for i in range(-30, 41, 1): # -30 ~ 40, 마지막 41은 포함안됨.
                # sleep(0.5) # 0.5초
                sleep(5)  # 5초
                rnd_ondo = rnd.randint(-5, 5) # -5에서 5사이의 난수 발생
                ondo = i + rnd_ondo  # 온도를 -30 ~ 40까지 서서히 증가 시킴
                print('ondo:', ondo)
                # client에게 전송, 전송 완료후 None 리턴
                msg = 'Raspberry 1/' + str(ondo)
                sock.sendall(msg.encode()) # encode(): 한글 전송시 깨짐 방지 처리
else:
    print('사용법: python3 Client_Raspberry.py 127.0.0.1')