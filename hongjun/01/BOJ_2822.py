li = []
for _ in range(8):
    li.append(int(input()))
sort_li = sorted(li, reverse=True)
idx = []
for i in sort_li[:5]:
    idx.append(li.index(i) + 1)
idx.sort()
print(sum(sort_li[:5]))
print(*idx)