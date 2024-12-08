n, m = map(int, input().split())
pack = []
one = []
INF = int(1e9)

for i in range(m):
    a, b = map(int, input().split())
    pack.append(a)
    one.append(b)

# 1. 패키지만으로 사는 방법
x = n//6
y = n%6
if y != 0:
    x += 1

min1 = INF
for i in range(m):
    min1 = min(min1, pack[i] * x)

# 2. 낱개로만 사는 방법
min2 = INF
for i in range(m):
    min2 = min(min2, one[i] * n)

# 3. 섞어서 구매
x3 = n//6
y3 = n%6
min3 = INF
for i in range(m):
    tmp = min(pack)*x3 + min(one)*y3
    min3 = min(min3, tmp)

print(min(min1, min2, min3))