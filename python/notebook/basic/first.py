''' 내가만든  모듈입니다.
    내부에는 변수와 함수가 하나씩 있습니다.
'''
 
print(__name__) #직접실행하면 __main__출력, import되서 실행되면 모듈명 출력
 
 
first_value = 100
 
def first_func(x, y):
    return x + y
 
 
if __name__ == '__main__' :
    print()
    print(__doc__)
    print("first_value",first_value)
    print("first_func", first_func(1,5))
