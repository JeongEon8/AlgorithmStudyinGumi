N = int(input())
li = list(map(int, input().split()))

st = 0
en = N-1

ans1 = 0
ans2 = 0
# 산성 용액만 또는 알칼리성 용액만 있을 때
if li[st] > 0 or li[en] < 0:
    ans1 = li[st]
    ans2 = li[en]

# 혼합 특성값의 최소값 구하기 -> 초기값 = 최대치
MIN = int(1e9)*2

while st < en:
    tmp = li[st] + li[en]
    if tmp < 0:
        tmp *= -1
        if tmp < MIN:
            MIN = tmp
            ans1 = li[st]
            ans2 = li[en]
        st += 1
    elif tmp > 0:
        if tmp < MIN:
            MIN = tmp
            ans1 = li[st]
            ans2 = li[en]
        en -= 1
    else:
        ans1 = li[st]
        ans2 = li[en]
        break

print(ans1, ans2)