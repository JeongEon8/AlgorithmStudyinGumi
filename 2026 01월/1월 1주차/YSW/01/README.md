# [백준 - S2] 17245. 서버실 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 이분 탐색
- 매개 변수 탐색

## ⏲️**Time Complexity**

$O(N^2logN)$

## :round_pushpin: **Logic**

모든 칸의 높이 합을 미리 계산합니다.
물 높이를 시간으로 보고 0부터 최대 높이까지를 탐색 범위로 설정합니다.
특정 시간 t에 대해, 각 칸에서 잠긴 높이를 min(높이, t)로 계산하여 전체 잠긴 높이를 구합니다.
이 값이 전체 높이의 절반 이상인지 판별합니다.
조건을 만족하는 가장 작은 t를 이분 탐색으로 찾습니다.

```java
		if (totalComputer == 0) {
			System.out.println(0);
		} else {
			int start = 0;
			int end = maxHeight;
			int result = Integer.MAX_VALUE;

			while (start <= end) {
				int mid = (start + end) / 2;

				if (halfCom(mid)) {
					result = mid;
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}

			System.out.println(result);
		}
	private static boolean halfCom(int mid) {
		long activeCom = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				activeCom += Math.min(rack[i][j], mid);
			}
		}

		if ((totalComputer / 2) + (totalComputer % 2) <= activeCom) {
			return true;
		} else {
			return false;
		}
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/17245
