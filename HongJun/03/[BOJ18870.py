import sys
input = sys.stdin.readline

n = int(input())
dic={}
li=list(map(int, input().strip().split()))
sort_li = sorted(set(li))

for i in range(len(sort_li)):
    dic[sort_li[i]] = i
for i in li:
    print(dic[i], end=' ')