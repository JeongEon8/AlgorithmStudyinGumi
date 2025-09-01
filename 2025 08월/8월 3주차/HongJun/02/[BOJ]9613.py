# 유클리드 호제법
def gcd(a, b):
    if (b == 0):
        return a
    return gcd(b, a%b)

t = int(input())

for _ in range(t):
    res = 0
    li = list(map(int, input().split()))
    n = li[0]
    for i in range(1, n):
        for j in range(i+1, n+1):
            res += gcd(li[j], li[i])
    print(res)