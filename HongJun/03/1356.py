n = input()
li = []
for i in n:
    li.append(int(i))

size = len(li)
flag = False

for i in range(size - 1):
    one = li[:i+1]
    two = li[i+1:]

    tmp1, tmp2 = 1, 1
    for a in one:
        tmp1 *= a
    for b in two:
        tmp2 *= b

    if tmp1 == tmp2:
        flag = True
        break

if flag:
    print("YES")
else:
    print("NO")