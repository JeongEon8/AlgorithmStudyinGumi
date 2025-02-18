# [백준 - S1] 2343. 기타 레슨
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
이분 탐색색

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
```python
while start <= end:
    mid = (start + end) // 2    # 블루레이 크기
    cnt = 1     # 블루레이 개수
    tmp = 0     # 레슨 합

    for i in range(n):
        if tmp + li[i] <= mid:      # 블루레이 공간이 남았음
            tmp += li[i]
        else:                       # 블루레이 크기보다 커지면 개수 +1해주고 초기화
            cnt += 1
            tmp = li[i]

    if cnt <= m:        # 블루레이 개수가 부족하면 크기 줄여야함
        end = mid - 1

    else:               # 블루레이 개수가 넘어가면 크기 늘려야함
        start = mid + 1
```

## :black_nib: **Review**
이분탐색 어렵다...

## 📡**Link**
- https://www.acmicpc.net/problem/2343
