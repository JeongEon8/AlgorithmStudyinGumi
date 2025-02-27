# [백준 - S1] 14247. 나무 자르기

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
모든 나무의 갯수가 n개이고 나무도 n번 자를 수 있으므로 모든 나무를 1번씩 자르고 성장속도가 빠른나무를 뒤에 자르는 경우가 벌목한 나무의 길이가 최대가 되는 경우다.
```java
Arrays.sort(trees);
long ans = 0;
for (int i = 0; i < n; i++) {
	ans += trees[i].start + trees[i].grow * i;
}
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/14247
