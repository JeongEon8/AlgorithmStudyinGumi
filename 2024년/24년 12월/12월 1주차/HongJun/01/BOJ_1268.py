n = int(input())
grade = [[] for _ in range(5)]

for i in range(n):
    a, b, c, d, e = map(int, input().split())
    grade[0].append(a)
    grade[1].append(b)
    grade[2].append(c)
    grade[3].append(d)
    grade[4].append(e)

res = [[] for _ in range(n)]
for i in range(5):
    van = grade[i]
    for j in range(n):
        for k in range(n):
            if j==k:
                continue
            if van[j] == van[k]:
                res[j].append(k+1)

ans = []
for tmp in res:
    ans.append(len(set(tmp)))
mx = max(ans)
for i in range(n):
    if ans[i] == mx:
        print(i+1)
        break