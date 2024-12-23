n = int(input())
arr = list(map(int, input().split()))

ans = 0
left = 0
count = {}
distinct_count = 0

for right in range(n):
    if arr[right] in count:
        count[arr[right]] += 1
    else:
        count[arr[right]] = 1
        distinct_count += 1

    while distinct_count > 2:
        count[arr[left]] -= 1
        if count[arr[left]] == 0:
            del count[arr[left]]
            distinct_count -= 1
        left += 1

    ans = max(ans, right - left + 1)

print(ans)