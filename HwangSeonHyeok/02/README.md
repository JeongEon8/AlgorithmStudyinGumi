# [백준 - S5] 15720. 카우버거

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 수학
- 구현
- 그리디 알고리즘
- 정렬
- 사칙연산

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
할인률은 일정하므로 가장 비싼것끼리 세트를 만들고 남은 단품들 가격을 더해준다.

```java
Arrays.sort(burger);
Arrays.sort(side);
Arrays.sort(beverage);
int min = Math.min(b, Math.min(c, d));
int sale = 0;
for (int i = 0; i < min; i++) {
	int set = (int) ((burger[i] + side[i] + beverage[i]) * 0.9);
	sale -= set;
}
for (int i = min; i < b; i++) {
	sale -= burger[i];
}
for (int i = min; i < c; i++) {
	sale -= side[i];
}
for (int i = min; i < d; i++) {
	sale -= beverage[i];
}
```

## :black_nib: **Review**
comperator를 만들기 싫어서 그냥 음수로 저장하고 오름차순으로 정렬했습니다.
## 📡**Link**

https://www.acmicpc.net/problem/15720
