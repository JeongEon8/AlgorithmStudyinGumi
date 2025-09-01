t = int(input())
for _ in range(t):
    n = int(input())
    cnt = 0
    total = 0
    res = 0
    p = list(map(int, input().split()))
    max_price = max(p)
    end_price = p[-1]
    for i in range(n - 1):
        if end_price == max_price:
            cnt += 1
            total += p[i]
        else:
            if p[i] < max_price:
                cnt += 1
                total += p[i]
            elif p[i] == max_price:
                res += (p[i] * cnt) - total
                cnt = 0
                total = 0
                max_price = max(p[i + 1:])

    res += (end_price * cnt) - total
    print(res)