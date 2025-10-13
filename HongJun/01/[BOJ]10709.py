H, W = map(int, input().split())
arr = [input() for _ in range(H)]

for a in arr:  # 한 줄씩 순회
    lst = [-1 for _ in range(W)]
    for i in range(W):
        if a[i] == 'c':
            lst[i] = 0
    tmp = 0
    for i in range(1, W):
        if lst[i] == 0:
            tmp = 0
        if lst[i - 1] != -1:
            if lst[i] != 0:
                tmp += 1
                lst[i] = tmp
    print(*lst)