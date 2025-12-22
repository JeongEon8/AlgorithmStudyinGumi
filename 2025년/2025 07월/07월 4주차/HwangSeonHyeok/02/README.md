# [백준 - S4] 30404. 오리와 박수치는 춘배

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
오리가 울었을때 예약된 박수가 없으면 k초후에 박수를 예약하는 식으로 진행하면 최소한의 박수만 칠 수 있다.
```java
for (int i = 0; i < n; i++) {
    int duck = Integer.parseInt(st.nextToken());
    if (duck > current) {
        current = duck + k;
        ans++;
    }
}
```
## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/30404