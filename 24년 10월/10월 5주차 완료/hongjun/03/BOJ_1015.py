N = int(input())
arr = list(map(int, input().split()))
sort_arr = sorted(arr)
#
# arr ->  2 1 3 1
#
# srot -> 1 1 2 3

res = []
for i in range(N):
    for j in range(N):
        if arr[i] == sort_arr[j]:
            if j in res:
                res.append(j+1)
            else:
                res.append(j)
            sort_arr[j] = -1
            break
print(*res)