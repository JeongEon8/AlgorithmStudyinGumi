# [백준 - S5] 20115. 에너지 드링크 (Easy)

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**

에너지 드링크를 양 순서로 오름차순 한 다음 첫번째 음료수부터 마지막 전 음료수를 2로 나눠서 마지막 드링크에 더해준다.

```java
		Arrays.sort(drink);

		for (int i = 0; i < drink.length - 1; i++) {
			drink[N - 1] += drink[i] / 2;
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/20115
