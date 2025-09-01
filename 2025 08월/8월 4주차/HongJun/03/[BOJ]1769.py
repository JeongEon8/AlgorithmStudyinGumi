n = input()
c=0
while len(n)>=2:# int(n)>=10 ->len(n)>=2
    t = 0
    for i in range(len(n)):
        t+=int(n[i])
    n=str(t)
    c+=1
print(c)
if int(n)%3==0:
    print("YES")
else:
    print('NO')