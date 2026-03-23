# [백준 - S2] 14465. 소가 길을 건너간 이유 5 (Easy)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 누적 합
- 슬라이딩 윈도우

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

먼저 1번부터 N번까지의 신호등 상태를 배열에 저장한 후, 슬라이딩 윈도우 기법을 적용했다. 먼저 처음 K개 구간의 고장 난 신호등 개수를 구하고, 이후 윈도우를 한 칸씩 이동시키며 새로 들어오는 신호등과 범위를 벗어나는 신호등의 상태만 체크하여 고장 난 신호등의 개수를 갱신 했다. 그리고 고장 난 신호등 개수의 최솟값을 출력했다.

```java
		int count = 0;
		for (int i = 1; i <= K; i++) {
			if (isBroken[i] == true) {
				count++;
			}
		}

		int minCount = count;
		for (int i = K + 1; i <= N; i++) {
			if (isBroken[i]) {
				count++;
			}

			if (isBroken[i - K]) {
				count--;
			}

			minCount = Math.min(minCount, count);
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/14465
