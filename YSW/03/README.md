# [백준 - S2] 32982. 약물 복용 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현
- 그리디 알고리즘
- 시뮬레이션

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**

식사를 하는 시간을 현재 시간으로 하고 현재 시간에서 약효가 다음 식사 시간 범위보다 작은 경우가 있다면 "NO"를 출력하고 없다면 "YES"를 출력하게 했다.

```java
		for (int i = 0; i < N; i++) {
			if (mealTime[2] > currentTime + K) {
				System.out.println("NO");
				return;
			}
			currentTime = Math.min(currentTime + K, mealTime[3]);

			if (mealTime[4] > currentTime + K) {
				System.out.println("NO");
				return;
			}
			currentTime = Math.min(currentTime + K, mealTime[5]);

			if (i < N - 1) {
				if (mealTime[0] > currentTime + K - 1440) {
					System.out.println("NO");
					return;
				}
				currentTime = Math.min(currentTime + K - 1440, mealTime[1]);
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/32982
