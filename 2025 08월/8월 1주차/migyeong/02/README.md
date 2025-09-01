# [백준] 3079. 입국심사


## ⏰ **time**
50분

## :pushpin: **Algorithm**
이분 탐색

## ⏲️**Time Complexity**
O(N log N)

## :round_pushpin: **Logic**
1. 최소 시간(left)과 최대 시간(right)을 구함
2. 이분 탐색으로 가능한 최소 기간 찾기
3. 현재 시간(mid) 내에 처리 가능한 총 인원 계산
3. 처리 인원이 사람 수(M) 이상이면 시간 줄이기 (right=mid-1)
4. 처리 인원이 부족하면 시간 늘리기 (left=mid+1)

```java
while (left <= right) {
        long mid = (left + right) / 2;
        long cnt = 0;
        for (long t : times) {
        cnt += mid / t;
        if (cnt >= M) break;
        }
        if (cnt >= M) {
        ans = mid;
        right = mid - 1;
        } else {
        left = mid + 1;
        }
}
```

## :black_nib: **Review**
이분탐색이 너무 어렵네여

## 📡**Link**
https://www.acmicpc.net/problem/3079
