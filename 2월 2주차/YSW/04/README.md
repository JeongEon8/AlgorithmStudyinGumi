# [백준 - S3] 10025. 게으른 백곰 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 누적 합
- 두 포인터
- 슬라이딩 윈도우

## ⏲️**Time Complexity**

$O(L)$

## :round_pushpin: **Logic**

길이 2k+1인 첫 번째 구간의 합을 먼저 계산합니다. 이것을 초기 윈도우로 설정합니다.
윈도우를 한 칸 오른쪽으로 이동시키면서 왼쪽 값을 빼고 새로 포함되는 오른쪽 값을 더합니다.
이 과정을 반복하며 최대값을 갱신합니다.

```java
		long sumIceWeight = 0;
		for (int i = minLocation; i <= minLocation + 2 * k && i <= 1000000; i++) {
			sumIceWeight += iceWeights[i];
		}

		long maxSumIceWeight = sumIceWeight;
		for (int i = minLocation; i <= maxLocation - k; i++) {
			sumIceWeight -= iceWeights[i];
			if (i + 2 * k + 1 <= 1000000) {
				sumIceWeight += iceWeights[i + 2 * k + 1];
			}
			maxSumIceWeight = Math.max(maxSumIceWeight, sumIceWeight);
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/10025