# [백준 - 골드 4] 14500. 테트로미노
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(N*M)$

## :round_pushpin: **Logic**
1. 모든 칸을 시작점으로 하는 dfs 진행
2. dfs로 최대 4칸까지 이어지는 블록의 합을 계산
3. 특수 모양 (ㅗ)은 dfs로 만들 수 없기 때문에 dfs 깊이 2일 때, 분기하여 한 칸 더 탐색
4. 모든 위치 탐색 후 최대값 출력
```java
if (!visit[cx][cy]) {
	// 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행
	if (count == 2) {
		visit[cx][cy] = true;
		solve(row, col, sum + map[cx][cy], count + 1);
		visit[cx][cy] = false;
	}

	visit[cx][cy] = true;
	solve(cx, cy, sum + map[cx][cy], count + 1);
	visit[cx][cy] = false;
}
```

## :black_nib: **Review**
- 블로그에서 풀이법 보고 간신히 풀었습니다... 다 본 문제도 다시 읽자..

## 📡 Link
https://www.acmicpc.net/problem/14500
