# [백준 - S4] 20363. 당근 키우기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
햇빛과 물중 더 많이 필요한 것을 더 적게필요한것으로 깎이는 수치만큼 넘치게 미리 주고 적게 필요한것을 주면 최소한의 횟수로 조건을 충족한다.
```java
int high = Math.max(x, y);
int low = Math.min(x, y);
int ans = high + (low / 10) + low;
```
## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/20363