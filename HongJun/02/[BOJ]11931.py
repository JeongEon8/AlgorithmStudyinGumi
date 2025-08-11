import heapq
import sys

input = sys.stdin.readline

n = int(input())
nums = []
for _ in range(n):
    heapq.heappush(nums, int(input())*-1)

for i in range(n):
    print(heapq.heappop(nums)*-1)