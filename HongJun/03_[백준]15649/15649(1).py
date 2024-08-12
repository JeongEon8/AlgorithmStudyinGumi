N,M = map(int, input().split())
res = []

def back():
    if len(res) == M:
        print(' '.join(map(str, res)))
        return
    for i in range(1, N+1):
        if i not in res:
            res.append(i)
            back()
            res.pop()

back()