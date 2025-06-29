# [백준 - S3] 11561. 징검다리

## ⏰  **time**
20분

## :pushpin: **Algorithm**
이분탐색

## ⏲️**Time Complexity**
$O(log(n)^T)$

## :round_pushpin: **Logic**
1. 최대값을 N으로 두고, 양 극단의 중앙의 값으로 급수 계산을 하며 범위를 좁혀나가면 된다.
```cpp
    while (left <= right) {
        mid = (left + right) / 2;

        if (mid * (mid + 1) / 2 <= N) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }
```

## :black_nib: **Review**
- 이분탐색 너무 어려워잉...
- 잉잉 브론즈 풀고 싶어요ㅠㅠ

## 📡 Link
https://www.acmicpc.net/problem/11561
