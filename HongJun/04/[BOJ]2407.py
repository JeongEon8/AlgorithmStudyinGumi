def fact(n):
    if n > 1:
        return n*fact(n-1)
    else:
        return 1


n, m = map(int, input().split())
temp = 1

for i in range(m):
    temp = temp*(n-i)
m = fact(m)
result = temp//m

print(result)