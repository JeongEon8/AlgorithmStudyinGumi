n, m = map(int, input().split())
li = []
for _ in range(n):
    li.append(list(input()))

if n >= m:
    max_cnt = m
else:
    max_cnt = n

for size in range(max_cnt, 0, -1):
    for y in range(n-size+1):
        for x in range(m-size+1):
            if li[y][x] == li[y+size-1][x] == li[y][x+size-1] == li[y+size-1][x+size-1]:
                print(size**2)
                exit()