from collections import deque

t = int(input())

for _ in range(t):
    com = input()
    n = int(input())
    #deq = deque(map(int, input()[1:-1].replace(',','')))        # 입력받은거 int로 변환
    deq = deque(input()[1:-1].split(','))  # str로 입력받기

    if n==0:
        deq = deque()
        
    rev = 0         # 뒤집기 몇 번 하는지
    for i in com:
        if i == 'R':
            rev += 1
        else:       # D 입력받을 떄
            if len(deq) == 0:   # 덱이 비어있으면 에러
                print('error')
                break
            else:
                if rev % 2 == 0:    # 짝수번 뒤집으면 똑같음. 그대로 진행
                    deq.popleft()
                else:
                    deq.pop()

    else:       # 위의 for문에서 break 되지 않으면 실행
        if rev % 2 == 0:        # 뒤집기 숫자가 짝수면 그대로 출력
            print('['+','.join(deq)+']')
        else:                   # 홀수면 뒤집은 다음 출력
            deq.reverse()
            print('['+','.join(deq)+']')