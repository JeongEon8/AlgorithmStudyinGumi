n = int(input())
tree = list(map(int, input().split()))
sort_tree = sorted(tree, reverse=True)

result = []
for i in range(n):
  day = (i+1) + sort_tree[i] + 1
  result.append(day)

print(max(result))
