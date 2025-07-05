# [백준- G4] 2458. 키 순서
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
플로이드-워셜

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**
- 플로이드-워셜 알고리즘으로 모든 경로 탐색
- 각 학생에 대해 자신보다 크거나 작은 학생의 수를 계산
- 자신의 순서를 확실히 알 수 있는 학생이면 결과 증가
```java
// 플로이드-워셜 알고리즘으로 모든 경로 탐색
for (int k = 1; k <= N; k++) {
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (graph[i][k] && graph[k][j]) {
				graph[i][j] = true;
			}
		}
	}
}
```

## :black_nib: **Review**
- 플로이드-워셜을 다시 상기시킬 수 있었습니다.

## 📡**Link**
- https://www.acmicpc.net/problem/2458
