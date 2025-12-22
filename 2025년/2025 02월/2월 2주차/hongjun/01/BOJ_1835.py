from collections import deque

n = int(input())
q = deque()
cnt = n
for i in range(n, 0, -1):
    q.appendleft(i)
    for j in range(cnt):
        tmp = q.pop()
        q.appendleft(tmp)
    cnt -= 1
result = []
while q:
    result.append(q.popleft())
print(*result)