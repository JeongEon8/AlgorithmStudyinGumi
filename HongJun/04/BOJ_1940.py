N = int(input())
M = int(input())
li = list(map(int, input().split()))
li.sort()

st = 0
en = N-1
ans = 0

while st < en:
    if li[st]+li[en] < M:
        st += 1
    elif li[st]+li[en] > M:
        en -= 1
    else:
        ans += 1
        st += 1
        en -= 1

print(ans)