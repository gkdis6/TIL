'''
모듈을 작성합니다.
pi변수와 두개의 함수가 있습니다.
'''
pi = 3.14

def oneHapN(end):    # 1부터 N까지의 합을 구해주는 함수
    sum = 0
    for i in range(end):
        sum += i+1
    return sum
 
def oneGopN(end):    # 1부터 N까지의 곱을 구해주는 함수
    total = 1
    for i in range(end):
        total *= i+1
    return total
