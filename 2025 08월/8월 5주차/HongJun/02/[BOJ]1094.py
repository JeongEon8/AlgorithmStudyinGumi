x=int(input())
a = [64, 32, 16, 8, 4, 2, 1]
res =[]
for i in a:
    if x < i:
        continue
    res.append(i)
    if sum(res) > x:
        res.pop()
    elif sum(res) == x:
        break
print(len(res))