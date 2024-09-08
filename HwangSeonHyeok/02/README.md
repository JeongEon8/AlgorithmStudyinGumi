# [백준 - s5] 9655. 돌 게임

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 수학
- 다이나믹 프로그래밍
- 게임 이론

## :round_pushpin: **Logic**

자신이 이길 수 있는 경우에 대해서 true로 두고 모든 경우의수가 이길 수 없으면 패배한다.

```java
  static boolean solve(int stone, int turn) {
		if (visited[stone][turn])
			return dp[stone][turn];
		visited[stone][turn] = true;
		if (stone == 0) {
			return dp[stone][turn] = false;
		}
		boolean thisTurnWin = false;
		if (stone - 1 >= 0) {
			thisTurnWin = thisTurnWin || !solve(stone - 1, (turn + 1) % 2);
		}
		if (stone - 3 >= 0) {
			thisTurnWin = thisTurnWin || !solve(stone - 3, (turn + 1) % 2);
		}

		return dp[stone][turn] = thisTurnWin;
	}

```

## :black_nib: **Review**

게임 이론 문제 쉬운 문제로 한문제 더 풀어보았다.  
구술 게임과 다르게 풀이 하나의 풀에서 1개, 3개 두종류만 뽑을 수 있는 경우다.  
구슬게임은 true는 항상 1p가 이기는 경우를 생각했는데 여기선 각각의 차례에 자신이 이길 수 있는지로 잡았다.  
구슬게임도 그렇게 푸는게 더 깔끔했을듯.

## 📡**Link**

https://www.acmicpc.net/problem/9655
