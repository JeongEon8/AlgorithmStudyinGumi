na, nb = map(int, input().split())
a = set(map(int, input().split()))
b = set(map(int, input().split()))
res = a-b
print(len(res))
print(*sorted(res))