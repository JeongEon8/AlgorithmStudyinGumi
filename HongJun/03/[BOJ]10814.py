import sys
input = sys.stdin.readline

n=int(input())
li=[]
for i in range(n):
    li.append(input().split())
li.sort(key=lambda x:int(x[0]))
for i in range(n):
    print(li[i][0], li[i][1])