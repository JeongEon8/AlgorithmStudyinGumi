n=int(input())
li=[]
for i in range(n):
    li.append(int(input()))
li.sort(reverse=True)
res = []
tmp = 0
for i in range(n):
    num = i+1
    res.append(li[i]*num)
print(max(res))