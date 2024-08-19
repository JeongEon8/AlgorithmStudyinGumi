from itertools import combinations

while True:
    line = list(map(int, input().split()))
    k = line[0]
    if k == 0:
        break
    lotto = line[1:]
    result = list(combinations(lotto, 6))
    for res in result:
        print(*res)
    print()
