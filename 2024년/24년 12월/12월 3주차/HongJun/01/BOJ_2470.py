N = int(input())
li = list(map(int, input().split()))
# 리스트 정렬
li.sort()

st = 0
en = N-1

ans1 = 0
ans2 = 0

# 산성 용액만 또는 알칼리성 용액만 있을 때는 (맨 앞 + 맨 뒤)가 답이다
if li[st] > 0 or li[en] < 0:
    ans1 = li[st]
    ans2 = li[en]

# 혼합 특성값의 최소값 구하기
# 초기값 = 1'000'000'000 * 2
MIN = int(1e9)*2

# 투포인터
while st < en:
    tmp = li[st] + li[en]
    # 합이 - 일 때
    if tmp < 0:
        tmp *= -1
        # 더한 값이 더 작으면 갱신
        if tmp < MIN:
            MIN = tmp
            ans1 = li[st]
            ans2 = li[en]
        # st 포인터를 오른쪽으로 이동
        st += 1

    # 합이 + 일 때
    elif tmp > 0:
        # 더한 값이 더 작으면 갱신
        if tmp < MIN:
            MIN = tmp
            ans1 = li[st]
            ans2 = li[en]
        # en 포인터를 왼쪽으로 이동
        en -= 1
    # 더한 값이 0이면 그게 정답임
    else:
        ans1 = li[st]
        ans2 = li[en]
        break

print(ans1, ans2)