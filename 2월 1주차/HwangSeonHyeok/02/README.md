# [백준 - S1] 26091. 현대모비스 소프트웨어 아카데미

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬
- 두 포인터

## ⏲️**Time Complexity**

$O(nlogn)$

## :round_pushpin: **Logic**
매 구간마다 신호등을 기다렸다 건너는게 빠른지 육교로 건너는게 빠른지 비교해서 더 빠른 코스를 선택하면된다.
```java
Arrays.sort(stats);
int left = 0;
int right = n - 1;
int ans = 0;
while (left < right) {
    if (stats[left] + stats[right] >= m) {
        ans++;
        left++;
        right--;
    } else {
        left++;
    }
}
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/26091