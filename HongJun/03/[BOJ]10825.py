import sys
input = sys.stdin.readline

li = []
n = int(input())
for i in range(n):
    li.append(input().split())

sort_li = sorted(li, key=lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))

for i in sort_li:
    print(i[0])