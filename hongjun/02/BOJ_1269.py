import sys
input = sys.stdin.readline
a, b = map(int, input().split())
s1 = set(map(int, input().split()))
s2 = set(map(int, input().split()))
a_b = s1-s2
b_a = s2-s1
print(len(a_b)+len(b_a))