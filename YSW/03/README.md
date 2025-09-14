# [백준 - S3] 9715. Surface Area (Easy)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 구현
- 기하학
- 3차원 기하학

## ⏲️**Time Complexity**

$O(n*m)$

## :round_pushpin: **Logic**

눈에 보이는 표면적을 구하는 문제였다. 천장과 바닥에서의 표면적과 상하좌우 관점에서 볼때 표면적을 구하는데 다음 블럭으로 갈때 바로 이전의 블럭의 높이를 고려 하는 식으로 표면적을 구했다.

```java
			for (int i = 0; i < row; i++) {
				strArr = br.readLine().split("");
				for (int j = 0; j < col; j++) {
					ground[i][j] = Integer.parseInt(strArr[j]);
					if (ground[i][j] != 0) {
						result += 2;
					}
				}
			}

			// 상
			for (int i = 0; i < col; i++) {
				int before = 0;
				for (int j = 0; j < row; j++) {
					int area = ground[j][i] - before;
					if (area > 0) {
						result += area;
					}
					before = ground[j][i];
				}
			}

			// 하
			for (int i = 0; i < col; i++) {
				int before = 0;
				for (int j = row - 1; j >= 0; j--) {
					int area = ground[j][i] - before;
					if (area > 0) {
						result += area;
					}
					before = ground[j][i];
				}
			}

			// 좌
			for (int i = 0; i < row; i++) {
				int before = 0;
				for (int j = 0; j < col; j++) {
					int area = ground[i][j] - before;
					if (area > 0) {
						result += area;
					}
					before = ground[i][j];
				}
			}

			// 우
			for (int i = 0; i < row; i++) {
				int before = 0;
				for (int j = col - 1; j >= 0; j--) {
					int area = ground[i][j] - before;
					if (area > 0) {
						result += area;
					}
					before = ground[i][j];
				}
			}
```

## :black_nib: **Review**

그냥 구현문제였다.

## 📡**Link**

https://www.acmicpc.net/problem/9715
