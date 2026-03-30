# [백준 - G4] 10830. 행렬 제곱 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 수학
- 분할 정복
- 분할 정복을 이용한 거듭제곱
- 선형대수학

## ⏲️**Time Complexity**

$O(logB)$

## :round_pushpin: **Logic**

N×N 행렬 A를 B번 곱한 결과를 구하는 행렬 거듭제곱 문제였다.
B번 반복해서 곱하면 시간 복잡도가 커지기 때문에, 분할 정복 방식을 사용해 계산 횟수를 줄여서 행렬을 곱해서 계산했다.

```java
	public static int[][] pow(int[][] A, long exp) {
		if (exp == 1L) {
			return A;
		}

		int[][] res = pow(A, exp / 2);
		res = multiply(res, res);

		if (exp % 2 == 1L) {
			res = multiply(res, origin);
		}

		return res;
	}

	public static int[][] multiply(int[][] m1, int[][] m2) {
		int[][] res = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
					res[i][j] %= 1000;
				}
			}
		}

		return res;
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/10830
