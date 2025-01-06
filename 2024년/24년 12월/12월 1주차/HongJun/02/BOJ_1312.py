a, b, n = map(int, input().split())

nam = a%b
res = []
for i in range(n):
    nam*=10
    tmp = nam // b
    nam %= b
    res.append(tmp)
print(res[n-1])