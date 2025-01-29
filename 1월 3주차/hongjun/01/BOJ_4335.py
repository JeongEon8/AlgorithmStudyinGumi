li = [True] * 11
li[0] = [False]
ans = []

while 1:
    n = int(input())
    if n == 0:
        break
    s = input()
    if s == "too high":
        for i in range(n, 11):
            li[i] = False
    elif s == "too low":
        for i in range(1, n+1):
            li[i] = False
    else:
        if li[n]:
            ans.append(1)
        else:
            ans.append(0)
        li = [True] * 11
        li[0] = [False]

for i in ans:
    if i == 0:
        print("Stan is dishonest")
    else:
        print("Stan may be honest")