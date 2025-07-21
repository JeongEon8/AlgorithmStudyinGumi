from collections import deque
import sys

input = sys.stdin.readline

n = int(input())
dq = deque()
for i in range(n):
    tmp = list(map(int, input().split()))

    if tmp[0] == 1:
        dq.append(tmp[1])
    elif tmp[0] == 2:
        if dq:
            pop_num = dq.pop()
            print(pop_num)
        else:
            print(-1)
    elif tmp[0] == 3:
        print(len(dq))
    elif tmp[0] == 4:
        if dq:
            print(0)
        else:
            print(1)
    elif tmp[0] == 5:
        if dq:
            print(dq[-1])
        else:
            print(-1)