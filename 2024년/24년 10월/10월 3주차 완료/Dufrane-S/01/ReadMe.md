# [백준 - S3] 13305. 주유소

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
가격을 보고 싼 경우에 구입하는 방식으로 진행

```java
		for (int i = 0; i < n; i++) {
			if (gas.get(i) < gprice) {
				gprice = gas.get(i);
				total += gprice * road.get(i);
			}
			else {
				total += gprice * road.get(i);
			}
		}
```

## :black_nib: **Review**
long 해줬는데 왜 58점인지 모르겠음

## 📡**Link**
https://www.acmicpc.net/problem/13305
