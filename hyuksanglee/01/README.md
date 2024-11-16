# [백준 - S4] 2217. 로프

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

로프가 버틸수 있는 중량을 오름차순으로 정렬하고 사용한 로프 중 가장 중량이 작은 무게\*사용한 로프수가 그 로프들로 들 수 있는 최대 중량이므로 가장작은 로프를 하나씩 빼가면서 계산한다.

```java
	Arrays.sort(ropes);
	long ans = 0;
	for (int i = 0; i < n; i++) {
		long total = (long) (n - i) * ropes[i];
		if (ans < total) {
			ans = total;
		}
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2217
