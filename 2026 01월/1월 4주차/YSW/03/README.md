# [백준 - S2] 11568. 민균이의 계략 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 가장 긴 증가하는 부분 수열 문제

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

하나의 정수가 적힌 N장의 카드를 정해진 순서대로 보여줄 때, 일부 카드를 임의로 선택하여 만들 수 있는 수열 중 순증가하면서 가장 길이가 긴 부분 수열의 길이를 구하는 문제이다.

이를 해결하기 위해 각 위치를 마지막 원소로 하는 최장 증가 부분 수열(LIS)의 길이를 동적 계획법으로 구한다.

수열의 각 인덱스 i에 대해, dp[i]를 i번째 원소를 마지막으로 하는 최장 증가 부분 수열의 길이로 정의한다. 모든 원소는 자기 자신만으로 길이 1의 부분 수열을 만들 수 있으므로 dp[i]의 초기값은 1로 설정한다.
인덱스 i보다 앞에 있는 모든 j(0 ≤ j < i)에 대해, nums[j] < nums[i]인 경우 j에서 끝나는 증가 부분 수열 뒤에 i번째 원소를 붙일 수 있다. 이때 dp[i] = max(dp[i], dp[j] + 1)로 값을 갱신한다.

모든 인덱스에 대해 dp 값을 계산한 후, dp 배열 중 최댓값이 전체 수열의 최장 증가 부분 수열의 길이가 된다.

```java
		int maxCount = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

			maxCount = Math.max(maxCount, dp[i]);
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/11568