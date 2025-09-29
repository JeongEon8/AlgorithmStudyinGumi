# [백준 - G5] 27980. 문자열 게임 (Nomal)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 문자열

## ⏲️**Time Complexity**

$O(N*M)$

## :round_pushpin: **Logic**

보드에서 현재 위치에서 오른쪽 왼쪽으로 이동할 경우로 재귀 호출 하고 오른쪽으로 이동한 경우와 왼쪽으로 이동한 경우중 point가 더 높은쪽이 더 최적이라고 판단해서 dp배열에 저장하고 dp값이 이미 존재한다면 계산하지 않는식으로 구현했다.

```java
		if (M == currentStringIndex) {
			return 0;
		}

		if (dp[currentBoardIndex][currentStringIndex] != -1) {
			return dp[currentBoardIndex][currentStringIndex];
		}

		int point = 0;

		if (currentBoardIndex > 0) {
			point = check(currentBoardIndex - 1, currentStringIndex + 1);
		}

		if (currentBoardIndex + 1 < N) {
			point = Math.max(point, check(currentBoardIndex + 1, currentStringIndex + 1));
		}

		if (board.charAt(currentBoardIndex) == word.charAt(currentStringIndex)) {
			++point;
		}

		return dp[currentBoardIndex][currentStringIndex] = point;
```

## :black_nib: **Review**

개인적으로 어려웠다. dp 배열을 사용하지 않고 dp값이 이미 존재한다면 계산하지 않는식으로 하면 시간초과가 났다. 동적프로그래밍 어려운거 같다. 재귀함수하는 연습이랑 동적프로그래밍 연습을 좀 더 해야할 꺼 같다.

## 📡**Link**

https://www.acmicpc.net/problem/27980
