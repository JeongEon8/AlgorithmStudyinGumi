import sys
input = sys.stdin.readline

n=int(input())
s1 = list(map(int, input().split()))
s2 = list(map(int, input().split()))
s1.sort()
s2.sort(reverse=True)
sum=0
for i in range(n):
    sum += s1[i]*s2[i]
print(sum) 