
# [백준- S5] 2563. 색종이

## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

- for문으로 영역 찾기

```java
for (int j = x; j < x + 10; j++) {
	for (int k = y; k < y + 10; k++) {
		if (!paper[j][k]) {
			paper[j][k] = true;
			area++;
		}
	}
}
```

## :black_nib: **Review**
- 


## 📡**Link**
- https://www.acmicpc.net/problem/2563

