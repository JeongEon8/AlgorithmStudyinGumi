n = int(input())

end = 0
count = 0
sum = 0

for start in range(n):
    while end < n and sum < n:
        sum += end+1
        end += 1
    if sum == n:
        count += 1
    sum -= start+1

print(count)