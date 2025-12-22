from collections import deque
import sys
input = sys.stdin.readline

stack_L = list(input().strip())             # 커서 왼쪽 = stack
deq_R = deque()                             # 커서 오른쪽 = deque

n = int(input())

for i in range(n):
    com = input().split()

    if com[0] == 'L' and stack_L:           # 왼쪽 스택에 문자가 존재해야 실행
        deq_R.appendleft(stack_L.pop())
    elif com[0] == 'D' and deq_R:           # 오른쪽 덱에 문자가 존재해야 실행
        stack_L.append(deq_R.popleft())
    elif com[0] == 'B' and stack_L:         # 왼쪽 스택에 문자가 존재해야 실행
        stack_L.pop()
    elif com[0] == 'P':
        stack_L.append(com[1])              # 그냥 왼쪽 스택에 입력 문자 추가
print(''.join(stack_L) + ''.join(deq_R))