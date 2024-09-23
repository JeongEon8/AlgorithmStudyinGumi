# [백준 - g4] 2239. 스도쿠

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현
- 백트래킹

## :round_pushpin: **Logic**

hasNum은 행, 열, 3\*3크기 보드에 해당 숫자가 있는지 기록해두기 위한 boolean 배열이다.  
시작할때 0인 곳을 eList에 기록해두고 그 칸에 1~9까지 해당숫자를 넣을 수 있는지만 canInsert함수로 판별해서 넣을 수 있으면 계속 진행하는 식으로 백트래킹한다.  
끝까지 모든 빈칸에 숫자를 넣으면 답이 나온것이고 숫자를 1~9로 오름차순으로 백트래킹하므로 처음 나온 답이 항상 사전식으로 앞서는 것이 보장된다.

```java
  static boolean[][][] hasNum = new boolean[3][9][10];// 0은 행 1은 열 2는 3*3
  static boolean canInsert(int y, int x, int num) {
		return !hasNum[0][y][num] && !hasNum[1][x][num] && !hasNum[2][x / 3 + (y / 3) * 3][num];
	}

  static void solve(int idx) {
		if (idx == eList.size()) {
			solved = true;
			return;
		}
		Empty c = eList.get(idx);
		for (int i = 1; i < 10; i++) {
			if (canInsert(c.y, c.x, i)) {
				hasNum[0][c.y][i] = true;
				hasNum[1][c.x][i] = true;
				hasNum[2][c.x / 3 + (c.y / 3) * 3][i] = true;
				board[c.y][c.x] = i;
				solve(idx + 1);
				if(solved)return;
				hasNum[0][c.y][i] = false;
				hasNum[1][c.x][i] = false;
				hasNum[2][c.x / 3 + (c.y / 3) * 3][i] = false;
				board[c.y][c.x] = 0;
			}
		}
	}

```

## :black_nib: **Review**

스도쿠를 채우는 문제. 단순 무식하게 백트래킹을 했다.  
n-queen과 비슷한 문제같다.

## 📡**Link**

https://www.acmicpc.net/problem/2239
