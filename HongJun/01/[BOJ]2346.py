n = int(input())
li = list(map(int, input().split()))
result = []
index_list = [i for i in range(1, n + 1)]

index = 0
temp = li.pop(index)
result.append(index_list.pop(index))

while li:
    if temp < 0:
        index = (index + temp) % len(li)
    else:
        index = (index + (temp - 1)) % len(li)

    temp = li.pop(index)
    result.append(index_list.pop(index))

print(' '.join(str(i) for i in result))