# [백준 - G4] 14499. 주사위 굴리기
 
## ⏰  **time**
3시간

## :pushpin: **Algorithm**
시뮬레이션

## ⏲️**Time Complexity**
$O(NM)$

## :round_pushpin: **Logic**
- 왼쪽, 오른쪽, 위, 아래 방향으로 이동할 때 변경되는 주사위 값을 직접 복사하면 됨
```java
			int down = dice[6];
			switch (cmd) {
			case 1: // 오른쪽
				dice[6] = dice[3];
				dice[3] = dice[1];
				dice[1] = dice[4];
				dice[4] = down;
				break;
			case 2: // 왼쪽
				dice[6] = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[3];
				dice[3] = down;
				break;
			case 3: // 위
				dice[6] = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[2];
				dice[2] = down;
				break;
			case 4: // 아래
				dice[6] = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[5];
				dice[5] = down;
				break;
			}
			sb.append(dice[1]).append("\n");

			// 칸에 적힌 수가 0인 경우, 주사위의 바닥면에 쓰여있는 수가 칸에 복사됨
			if (map[nx][ny] == 0) {
				map[nx][ny] = dice[6];
			}
			// 칸에 적힌 수가 0이 아닌 경우, 칸에 적혀있는 수가 주사위의 바닥면으로 복사 & 칸에 쓰여있는 수는 0이 됨
			else {
				dice[6] = map[nx][ny];
				map[nx][ny] = 0;
			}
			x = nx;
			y = ny;
		}
```

## :black_nib: **Review**
처음에 인덱스를 이용해서 주사위에 적힌 값을 이동시켰는데 제대로 이동되지 않는 문제가 생겼다. 다른 풀이를 보니 그냥 단순하게 값을 변경하길래 나도 그렇게 풀었다..
그렇게 간단하게 풀 수 있었다니........

## 📡**Link**
- https://www.acmicpc.net/problem/14499
