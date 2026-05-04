# [백준 - S4] 16162. 가희와 3단 고음

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
고음의 등차가 가능한 수가 나올때마다 카운트를 올리고 다음 찾을 고음을 기록한다.
```java
int cnt = 0;
for (int i = 0; i < n; i++) {
    int num = Integer.parseInt(st.nextToken());
    if (num == a) {
        cnt++;
        a += d;
    }
}
```
## :black_nib: **Review**

## 📡**Link**
https://www.acmicpc.net/problem/16162