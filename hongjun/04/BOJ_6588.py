import sys
input = sys.stdin.readline

MAX = 1000000

# 에라토스테네스 체로 소수만 True
prime = [True for i in range(MAX + 1)]
for i in range(2, int((MAX) ** 0.5) + 1):
    if prime[i]:
        j = 2
        while i * j <= MAX:
            prime[i * j] = False
            j += 1
res_a = 0
res_b = 0

while 1:
    n = int(input())
    if n == 0:
        break

    for i in range(2, MAX+1):
        if prime[i]:
            a = i
            b = n - a
            if prime[b]:
                res_a = a
                res_b = b
                break
    print(f'{n} = {res_a} + {res_b}')