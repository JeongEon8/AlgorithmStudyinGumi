import sys
input = sys.stdin.readline

n, m = map(int, input().split())
li = list(map(int, input().split()))

start = max(li)
end = sum(li)

while start <= end:
    mid = (start + end) // 2
    cnt = 1
    tmp = 0

    for i in range(n):
        if tmp + li[i] <= mid:
            tmp += li[i]
        else:
            cnt += 1
            tmp = li[i]

    if cnt <= m:
        end = mid - 1

    else:
        start = mid + 1

print(start)