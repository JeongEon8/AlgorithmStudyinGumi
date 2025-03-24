from collections import deque

n=int(input())
dq = deque()
for i in range(1, n+1):
    dq.append(i)

res = []
count=0
while dq:
    if count%2 == 0:
        res.append(dq.popleft())
    else:
        tmp = dq.popleft()
        dq.append(tmp)
    count += 1

print(*res)