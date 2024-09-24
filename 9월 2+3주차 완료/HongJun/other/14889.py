from itertools import combinations
import sys
input = sys.stdin.readline

n = int(input())
overall = []
for i in range(n):
    overall.append(list(map(int, input().split())))
li = [i for i in range(n)]

combi = list(combinations(li, n//2))
stat = []
link = []
for i in range(len(combi)//2):
    tmp = list(set(li) - set(list(combi[i])))
    stat.append(list(combi[i]))
    link.append(tmp)
    # if tmp not in stat:
    #     stat.append(list(i))
    #     link.append(tmp)

result = []
for i in range(len(stat)):
    sum_stat = 0
    sum_link = 0

    for y in stat[i]:
        for x in stat[i]:
            sum_stat += overall[y][x]

    for y in link[i]:
        for x in link[i]:
            sum_link += overall[y][x]
    res = abs(sum_stat - sum_link)
    result.append(res)
print(min(result))