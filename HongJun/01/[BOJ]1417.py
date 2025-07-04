import heapq

n = int(input())
my = 0
pq = []

for i in range(n):
    if i == 0:
        my = int(input())
    else:
        heapq.heappush(pq, int(input()) * -1)

result = 0

if n == 1:
    print(0)
else:
    while True:
        max_value = heapq.heappop(pq) * -1

        if my > max_value:
            print(result)
            break

        max_value -= 1
        my += 1
        result += 1
        heapq.heappush(pq, max_value * -1)