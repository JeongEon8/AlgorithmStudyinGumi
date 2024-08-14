# [SWEA - D4] 1861. 정사각형 방
 
## ⏰  **time**

1시간 40분
  
## :pushpin: **Algorithm**

DFS
  
## ⏲️**Time Complexity**

$O(N*3)$
    
## :round_pushpin: **Logic**

- 숫자 차이가 1이면 탐색! 아니면 탈출
void DFS(int y, int x) {
	for (int i = 0; i < 4; i++) {
		int ny = dy[i] + y;
		int nx = dx[i] + x;

		if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
			continue;
		}

		if (room[ny][nx] - room[y][x] == 1) { // <--- 이 조건이 있기 때문에 방문배열이 필요없다.
			cnt++;
			DFS(ny, nx);
		}
	}
}
```
  
## :black_nib: **Review**

- BFS로 하면 불필요한 방문탐색을 하기 때문에, DFS로 진행
- BFS로 풀었다가 시간초과나서 이것 저것 고치다가 시간 다썼다... 힝
  
## 📡 Link
https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZEXYkgaw8sDFAVs&contestProbId=AV5LtJYKDzsDFAXc&probBoxId=AZEXZ31qw_sDFAVs&type=PROBLEM&problemBoxTitle=8%EC%9B%9416%EC%9D%BC%28%EA%B8%88%29+%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B42&problemBoxCnt=2
