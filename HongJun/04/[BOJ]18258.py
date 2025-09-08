from collections import deque
import sys
input = sys.stdin.readline

n=int(input())
li = deque()
for _ in range(n):
    tmp = list(map(str, input().split()))

    match tmp[0]:
        case 'push':
            li.append(tmp[1])
        case 'pop':
            if not li:
                print(-1)
            else:
                print(li.popleft())
        case 'size':
            print(len(li))
        case 'empty':
            if not li:
                print(1)
            else:
                print(0)
        case 'front':
            if not li:
                print(-1)
            else:
                print(li[0])
        case 'back':
            if not li:
                print(-1)
            else:
                print(li[-1])