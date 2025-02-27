# [백준 - G4] 1461. 도서관

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
양수와 음수를 따로 구하고 각각 절댓값 내림차순으로 정렬을 하고 절댓값이 큰거부터 m개씩 세트로 왕복이동한다. 단 마지막 1번은 편도 이동만하므로 절댓값이 가장 큰 이동은 편도로계산한다.
```java
Collections.sort(plus, Collections.reverseOrder());
Collections.sort(minus);
int ans = -max;
for (int i = 0; i < plus.size();) {
	ans += plus.get(i) * 2;
	i += m;
}
for (int i = 0; i < minus.size();) {
	ans -= minus.get(i) * 2;
	i += m;
}
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/1461
