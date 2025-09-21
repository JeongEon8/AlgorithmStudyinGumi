# [백준 - S4] 10656. 십자말풀이 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N*M)$

## :round_pushpin: **Logic**

가로에서 시작하는 단어 일때 검사하고 세로 일때 경우를 검사해서 구현했다.

```java
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				// 가로
				if (puzzle[i][j].equals(".") && j + 2 <= M && !puzzle[i][j + 1].equals("#")
						&& !puzzle[i][j + 2].equals("#")) {
					if (j == 1 || puzzle[i][j - 1].equals("#")) {
						puzzle[i][j] = "" + count++;
					}
				}

				// 세로
				if (puzzle[i][j].equals(".") && i + 2 <= N && !puzzle[i + 1][j].equals("#")
						&& !puzzle[i + 2][j].equals("#")) {
					if (i == 1 || puzzle[i - 1][j].equals("#")) {
						puzzle[i][j] = "" + count++;
					}
				}
			}
		}
```

## :black_nib: **Review**

그냥 구현문제였다.

## 📡**Link**

https://www.acmicpc.net/problem/10656
