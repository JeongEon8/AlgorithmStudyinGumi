import sys
input = sys.stdin.readline

n = int(input())

P = []
C = []
for i in range(n):
    a, b = map(int, input().split())
    P.append(a)
    C.append(b)

x = 0
for i in range(n):
    if abs(P[i] - x) <= C[i]:
        x += 1
print(x)