# [백준 - S3] 8911. 거북이

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 시뮬레이션

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

도착한 최대 최소 X,Y값을 구하고 이를 이용해 가로 세로의 길이를 구하고 넓이를 구한다.

```java
	for (int j = 0; j < cmds.length(); j++) {
		switch (cmds.charAt(j)) {
			case 'F': {
				x += dx[dir];
				y += dy[dir];
				break;
			}
			case 'B': {
				x -= dx[dir];
				y -= dy[dir];
				break;
			}
			case 'L': {
				dir = (dir + 3) % 4;
				break;
			}
			case 'R': {
				dir = (dir + 1) % 4;
				break;
			}
		}
		maxY = Math.max(maxY, y);
		minY = Math.min(minY, y);
		maxX = Math.max(maxX, x);
		minX = Math.min(minX, x);
	}
	sb.append((maxY - minY) * (maxX - minX) + "\n");

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/8911
