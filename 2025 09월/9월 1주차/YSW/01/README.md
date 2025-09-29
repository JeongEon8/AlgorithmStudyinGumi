# [백준 - S2] 2805. 나무 자르기 (Nomal)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 이분 탐색
- 매개 변수 탐색

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

이분 탐색으로 조건에 맞게 나무 높이를 설정해서 M보다 많이 가져갈 수 있는 나무 중에서 제일 작은 높이를 찾는다.

```java
		long start = 0;
		long end = maxHeight;
		long result = 0;

		while (start <= end) {
			long mid = (start + end) / 2;
			long cutLengthSum = 0;

			for (int treeHeight : trees) {
				if (treeHeight > mid) {
					cutLengthSum += treeHeight - mid;
				}
			}

			if (cutLengthSum >= M) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(result);
```

## :black_nib: **Review**

이분 탐색은 헷갈리는 거 같다 잘 숙지해야 할 거 같다.

## 📡**Link**

https://www.acmicpc.net/problem/2805
