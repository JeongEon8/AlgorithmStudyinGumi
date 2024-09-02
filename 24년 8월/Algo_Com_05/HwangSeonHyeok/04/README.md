# [백준 - s4] 1049. 기타줄

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘

## :round_pushpin: **Logic**

단품 가격 최저가와 6개 패키지 가격 최솟값을 찾아서 모두 단품으로 사는경우, 패키지 단품 혼합해서 사는경우, 모두 패키지로 개수를 초과해서 사는 경우를 구해서 최저가를 찾는다.

```java
   int ans = Integer.MAX_VALUE;
    if (ans > minEach * n) {
        ans = minEach * n;
    }
    if (ans > (n / 6) * minPackage + (n % 6) * minEach) {
        ans = (n / 6) * minPackage + (n % 6) * minEach;
    }
    if (ans > (n / 6 + 1) * minPackage) {
        ans = (n / 6 + 1) * minPackage;
    }

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1049
