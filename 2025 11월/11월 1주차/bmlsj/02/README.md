
# [백준- G4] 2458. 키 순서

## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**

1. 각 학생별로 학생보다 큰 학생들과 작은 학생들을 
   -`bigger[i]`: 학생 i보다 큰 학생들의 리스트
   - `smaller[i]`: 학생 i보다 작은 학생들의 리스트

2. 각 학생 `i`에 대해 자신보다 큰 학생과 작은 학생 수를 BFS로 계산
3. 탐색한 학생 수를 카운트하여 반환

```java
for (int i = 0; i < m; i++) {
	split = br.readLine().split(" ");
	int small = Integer.parseInt(split[0]);
	int big = Integer.parseInt(split[1]);

	bigger[small].add(big);
	smaller[big].add(small);
}

int result = 0;
for (int i = 1; i <= n; i++) {
	int big = bfsCount(i, bigger);
	int small = bfsCount(i, smaller);

	if (small + big == n - 1) {
		result++;
	}
}
```


## :black_nib: **Review**


## 📡**Link**
- https://www.acmicpc.net/problem/2458

