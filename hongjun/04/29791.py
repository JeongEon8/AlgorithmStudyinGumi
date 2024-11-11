n, m = map(int, input().split())
nova = list(map(int, input().split()))
origin = list(map(int, input().split()))

nova.sort()
origin.sort()

st1 = nova[0]
res1 = 1
for i in range(1, n):
    if nova[i] < (st1 + 100):
        continue
    else:
        res1 += 1
        st1 = nova[i]

st2 = origin[0]
res2 = 1
for i in range(1, m):
    if origin[i] < (st2 + 360):
        continue
    else:
        res2 += 1
        st2 = origin[i]
        
print(res1, res2)


