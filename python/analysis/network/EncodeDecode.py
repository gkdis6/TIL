import sys
print(sys.getdefaultencoding())  # utf-8
msg = "데이터 analysis"
print(type(msg), msg)
byte_char = msg.encode()
print(type(byte_char), byte_char)  # b; byte 데이터 표시
tostr = byte_char.decode()
print(type(tostr), tostr)  # utf-8 데이터 표시