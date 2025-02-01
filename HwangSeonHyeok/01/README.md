# [백준 - S4] 1302. 베스트셀러

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
그냥 정렬하면 같은거끼리 연속해서 모이므로 카운팅해서 가장 많은 책제목을 찾는다.

```java
Arrays.sort(books);
String ans = books[0];
int max = 1;
int current = 1;
for (int i = 1; i < n; i++) {
	if (books[i].equals(books[i - 1])) {
		current++;
		if (max < current) {
			ans = books[i];
			max = current;
		}
	} else {
		current = 1;
	}
}
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/1302
