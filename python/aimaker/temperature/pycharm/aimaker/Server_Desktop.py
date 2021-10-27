# 5초마다 온도를 수집하여 저장하는 수집기 제작
# Desktop Oracle에 온도를 기록
from time import sleep
import random as rnd
import cx_Oracle  # Oracle
from sqlalchemy import create_engine  # Pandas -> Oracle
import socket
import sys

HOST = ''
PORT = 9009


# python Server_Desktop.py
def runServer():
    print('▷ 서버 종료시 Alt+F4를 누르세요.')
    try:
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:  # 자동 close
            sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
            sock.bind((HOST, PORT))  # 연결
            sock.listen(1)  # 최대 동시 연결 수
            while True:  # 계속적인 접속 요구 승인
                user_sock = None
                try:
                    print('▷ 접속 대기중...')
                    user_sock, addr = sock.accept()  # 접속 대기 및 접속자 연결
                    print('▷ [%s]와 연결됨' % addr[0])
                    while True:  # 계속적인 수신
                        data = user_sock.recv(1024)  # 수신 대기, Exception 발생시 종료
                        if not data:
                            break
                        values = data.decode().split('/')  # '/'로 분할
                        print(type(values))  # <class 'list'>
                        # 등록, SQL 마지막 부분에 세미콜론이 있으면 에러가 발생함으로 삭제 할 것
                        # Oracle Connection 연결, user1234 계정으로 XE 사용.
                        # conn = cx_Oracle.connect('user1234 /1234@192.168.219.101:1521/XE')
                        conn = cx_Oracle.connect('admin/Gksmf336!@database-1.cxfxuru6havp.ap-northeast-2.rds.amazonaws.com:1521/ORCL')
                        cursor = conn.cursor()
                        sql = '''
                        INSERT INTO ondo(ondono, kit, ondo, rdate)
                        VALUES(ondo_seq.nextval, :kit, :ondo, sysdate)
                        '''
                        result = cursor.execute(sql, (values[0], values[1]))
                        print('▷ result:', result)  # None: 정상 처리, Exception: 에러
                        conn.commit()  # sql commit;과 동일
                        print('▷ 수신된 value: ', values[0], values[1]);
                        # 온도는 소수 첫째자리까지 출력
                        print('▷ {0} 수집기로부터 온도 {1} 를 수신하여 기록했습니다.'.format(values[0],
                                                                          values[1]))
                except Exception as e:
                    pass  # Client 에러 발생해도 아무 처리 안하고 통과

                finally:
                    if user_sock:  # client 연결 닫기
                        user_sock.close()
    except Exception as e:
        print(e)


runServer()  # 서버 실행