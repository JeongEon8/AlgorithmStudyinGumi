# [백준 - S5] 3049. 다각형의 대각선

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 조합론

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
대각선 2개를 교차시키기위해선 4개의 꼭짓점이 필요하다.  
즉 대각선은 nC4의 교차점을 만든다.
```java
int point = (n * (n - 1) * (n - 2) * (n - 3)) / 24;
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/3049