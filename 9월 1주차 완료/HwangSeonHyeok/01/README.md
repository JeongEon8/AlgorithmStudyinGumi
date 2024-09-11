# [백준 - g4] 2600. 구슬게임

## ⏰ **time**

80분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 게임 이론

## :round_pushpin: **Logic**

선은 자신이 승리할 수있는 경우로 진행하고 후턴은 선이 질 수 있는 경우가 하나라도 있으면 무조건 그 경우로간다. 후턴이 a와 b가 0일때 턴을 진행하면 선턴이 승리하니 이를 a,b=0까지 내려갔다가 다시 올라오면 답을 구할 수 있다.

```java
  static boolean solve(int a, int b, int turn) {
		if (visited[a][b][turn]) {
			return dp[a][b][turn];
		}
		visited[a][b][turn] = true;
		
		if (turn == 1) {
			if (a == 0 && b == 0) {
				// 0 0에서 b차례면 a가 이길 수 있다.
				return dp[a][b][1] = true;
			} else {
				//b차례면 패배하는 경우가 있다면 거기로
				boolean current = true;
				for (int i = 0; i < 3; i++) {
					int tmp = a - bArray[i];
					if (tmp >= 0) {
						current = current && solve(tmp, b, 0);
					}
					tmp = b - bArray[i];
					if (tmp >= 0) {
						current = current && solve(a, tmp, 0);
					}
				}
				return dp[a][b][turn] = current;
			}
		} else {
			if (a == 0 && b == 0) {
				return dp[a][b][0] = false;
			} else {
				boolean current = false;
				for (int i = 0; i < 3; i++) {
					int tmp = a - bArray[i];
					if (tmp >= 0) {
						current = current || solve(tmp, b, 1);
					}
					tmp = b - bArray[i];
					if (tmp >= 0) {
						current = current || solve(a, tmp, 1);
					}
				}
				return dp[a][b][turn] = current;
			}
		}
	}

```

## :black_nib: **Review**

게임 이론은 대학때 이후로 처음 공부해봤는데 오랜만이라 많이 해맸다.  
처음엔 바텀업으로 세워나갔는데 탑다운으로 푸는게 맞는 풀이였다.

## 📡**Link**

https://www.acmicpc.net/problem/2600


