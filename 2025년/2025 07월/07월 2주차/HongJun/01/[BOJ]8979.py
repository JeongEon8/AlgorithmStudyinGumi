n, k = map(int, input().split())

medal = []

for i in range(n):
    medal.append(list(map(int, input().split())))

medal.sort(key=lambda x: (x[1], x[2], x[3]), reverse=True)

idx = [medal[i][0] for i in range(n)].index(k)

for j in range(n):
    if medal[idx][1:] == medal[j][1:]:
        print(j+1)
        break