# [백준 - G5] 2470. 두 용액

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 투포인터

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
```python
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
```

## :black_nib: **Review**
- 이분탐색으로도 풀 수 있는 것 같은데 찾아봐야징

## 📡**Link**

https://www.acmicpc.net/problem/2470