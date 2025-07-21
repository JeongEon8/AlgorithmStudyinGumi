n = int(input())
fac = 1
for i in range(1, n+1):
    fac *= i
s = str(fac)

res = 0
for i in s[::-1]:
    if i == '0':
        res += 1
    else:
        break
print(res)