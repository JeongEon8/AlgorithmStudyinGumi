# [백준 - G5] 2467. 용액

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 이분탐색, 투포인터

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 이미 정렬된 리스트가 입력되는 거라서 sort를 안해도 된다
```python
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
- 두 용액 문제랑 거의 똑같은거였넹..?

## 📡**Link**

https://www.acmicpc.net/problem/2467