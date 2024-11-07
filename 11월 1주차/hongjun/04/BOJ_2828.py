n, m = map(int, input().split())
st = 1  # 바구니 시작
en = m  # 바구니 끝

ans = 0
t = int(input())
for _ in range(t):
    k = int(input())
    if st <= k <= en:
        continue
    while 1:
        if st <= k <= en:
            break

        if en < k:
            ans += 1
            en += 1
            st += 1
        elif k < st:
            ans += 1
            en -= 1
            st -= 1
print(ans)