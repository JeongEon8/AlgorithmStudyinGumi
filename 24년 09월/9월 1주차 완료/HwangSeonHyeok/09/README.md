# [백준 - g1] 1799. 비숍

## ⏰ **time**

45분

## :pushpin: **Algorithm**

- 백트래킹

## :round_pushpin: **Logic**

흰색 칸의 비숍은 어떠한 움직임을 해도 검은색 칸의 비숍을 잡을 수 없다.  
모든 경우에 대해서 한번의 백트래킹으로 처리하면 시간복잡도는 $O(2^n)$이지만 흑 백 절반 나눠서 2번에 처리하면 $O(2^{n/2+1})$이므로 더 빠르게 처리가 가능하다.

좌표 x+y가 짝수인 흰색칸과 홀수인 검은색 칸을 따로 저장하고 각각 백트래킹해준다.

```java
    	for (int i = 0; i < n; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(split[j]);
				if (num == 1 && (i + j) % 2 == 0) {
					wList.add(new Empty(i, j));
				} else if (num == 1 && (i + j) % 2 == 1) {
					bList.add(new Empty(i, j));
				}
			}
		}
		wSolve(0, 0);
		bSolve(0, 0);

```

한번의 백트래킹과 비숍을 놓을 수 있는지 처리과정은 다음과 같다.  
이런식으로 검은 칸의 놓을 수 있는 최대 갯수와 흰 칸에 놓을 수 있는 최대 갯수의 합을 구하면된다.

```java
	static boolean canBishop(int y, int x) {
		for (int i = 0; i < n; i++) {
			int x1 = x - (y - i);
			int x2 = x + (y - i);
			if (x1 >= 0 && x1 < n && isBishop[i][x1]) {
				return false;
			}
			if (x2 >= 0 && x2 < n && isBishop[i][x2]) {
				return false;
			}
		}
		return true;
	}

	static void wSolve(int idx, int cnt) {

		if (idx == wList.size()) {
			if (cnt > wMax) {
				wMax = cnt;
			}
			return;
		}
		Empty e = wList.get(idx);
		if (canBishop(e.y, e.x)) {
			isBishop[e.y][e.x] = true;
			wSolve(idx + 1, cnt + 1);
			isBishop[e.y][e.x] = false;
		}
		wSolve(idx + 1, cnt);
		return;
	}
```

## :black_nib: **Review**

체스판의 크기가 10으로 크지않아 한번의 백트래킹으로 처리했다가 틀렸었다.  
백트래킹은 재귀가 깊어질수록 기하급수적으로 시행회수가 많아지니 비숍처럼 독립된 케이스가 있는 경우 분할하는 방법도 생각하자.

## 📡**Link**

https://www.acmicpc.net/problem/1799
