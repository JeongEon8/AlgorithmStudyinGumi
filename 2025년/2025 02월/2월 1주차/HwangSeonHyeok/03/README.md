# [백준 - S5] 11728. 배열 합치기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 투 포인터

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
입력은 이미 정렬된 상태이므로 각각의 인덱스를 두고 더 작은쪽을 계속 합치고 인덱스를 넘겨주면 되다.
```java
int aIdx = 0;
int bIdx = 0;
while (aIdx < n && bIdx < m) {
	if (A[aIdx] < B[bIdx]) {
		sb.append(A[aIdx++]).append(" ");
	} else {
		sb.append(B[bIdx++]).append(" ");
	}
}
while (aIdx < n) {
	sb.append(A[aIdx++]).append(" ");
}
while (bIdx < m) {
	sb.append(B[bIdx++]).append(" ");
}
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/11728
