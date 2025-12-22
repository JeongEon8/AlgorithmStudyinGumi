# [백준 - S4] 11508. 2+1 세일

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
가능한 비싼 가격의 상품을 할인받아야 최소 비용을 만들 수 있으므로 3n번째로 비싼 가격의 제품을 할인받으면 된다.
```java
Arrays.sort(arr);
int ans = 0;
for (int i = 0; i < n; i++) {
	if (i % 3 == 2)
		continue;
	ans -= arr[i];
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/11508
