import heapq

n = int(input())
card = []

for i in range(n):
    heapq.heappush(card, int(input()))

result = 0
while len(card) > 1:
    a = heapq.heappop(card)
    b = heapq.heappop(card)
    tmp = a + b
    result += tmp
    heapq.heappush(card, tmp)

print(result)