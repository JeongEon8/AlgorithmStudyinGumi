# [백준 - G2] 30242. 🧩 N-Queen (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현
- 백트래킹

## ⏲️**Time Complexity**

$O(n^2)$

## :round_pushpin: **Logic**

board[n]엔 체스판 n행에 퀸이 위치한 열 좌표가 들어있다.  
0이 들어있으면 아직 말을 안 놓은 열.  
재귀를 돌면서 각 행마다 퀸을 놓을 수 있는 위치를 찾으면서 백트래킹한다.  
퀸을 놓을 수 있는지를 판별할땐 같은 열에 이미 퀸이 있는지, 대각선에 있는지 여부를 체크한다.

```java

static void solve(int deep) {
		if(isFinished)return;

		if(deep>N) {
			isFinished = true;
			for(int i = 1; i<=N; i++) {
				System.out.print(board[i]+" ");
			}
			return;
		}
		if(board[deep]==0) {
			for(int i = 1; i<=N; i++) {
				boolean isPossible = true;
				for(int j = 1; j<=N; j++) {
					if(j==deep||board[j]==0) continue;
					if(board[j]==i) {
						isPossible = false;
						break;
					}
					if(Math.abs(board[j]-i)==Math.abs(deep-j)) {
						isPossible = false;
						break;
					}
				}
				if(isPossible) {
					board[deep] = i;
					solve(deep+1);
					board[deep] = 0;
				}else {
					board[deep] = 0;
				}
				if(isFinished)return;
			}
		}else {
			solve(deep+1);
			if(isFinished)return;

		}
	}
```

## :black_nib: **Review**

백트래킹 수업시간에 N-Queen문제를 언급하셔서 풀어본 문제  
싸피에서 JAVA 쓸 일이 많아 JAVA로 풀어보았다.

## 📡**Link**

- https://www.acmicpc.net/problem/30242
