# [백준 - S5] 28136. 원, 탁!

## ⏰ **time**

10분

## :pushpin: **Algorithm**
- 구현
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
모두 오름 차순인 순열을 만드려면 이전 index에 비해 숫자가 작아지는 부분에서 자르면 된다. 원형테이블이므로 배열의 마지막과 첫번째도 오름차순인지 확인해야한다.
```java
int ans = 0;
if (table[n - 1] >= table[0])
    ans++;
for (int i = 1; i < n; i++) {
    if (table[i - 1] >= table[i])
        ans++;
}
```

## :black_nib: **Review**  

## 📡**Link**
https://www.acmicpc.net/problem/28136