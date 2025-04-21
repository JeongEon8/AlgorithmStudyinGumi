# [백준 - 실버 5] 16212.정열적인 정렬

## ⏰  **time**
15분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. PriorityQueue를 이용해서 정렬하기
```java
for (int i = 0; i < N; i++) {
    pQueue.add(Integer.valueOf(st.nextToken()));
}
```

## :black_nib: **Review**
- StringBuilder를 써야지만 통과라니 잉

## 📡 Link
https://www.acmicpc.net/problem/16212
