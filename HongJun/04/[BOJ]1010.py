def facto(n):
    res = 1
    for i in range(1, n+1):
        res *= i
    return res

a=int(input())

for _ in range(a):
    n,m = map(int, input().split())
    ans = facto(m) // (facto(m-n) * facto(n))
    print(ans)