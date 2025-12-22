n = int(input())
max = []
for i in range(1, n + 1):
    li = [n]
    li.append(i)

    idx = 1
    while 1:
        next = li[idx - 1] - li[idx]
        if next < 0:
            break
        li.append(next)
        idx += 1
    if len(max) < len(li):
        max = li
print(len(max))
print(*max)