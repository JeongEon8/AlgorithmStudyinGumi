# [백준 - S4] 17254. 키보드 이벤트

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
시간이 빠른걸 우선, 시간이 같다면 키보드 번호가 빠른것 우선이므로 아래와 같은 class를 만들어 입력받고 정렬하면 된다.

```java
static class Typing implements Comparable<Typing> {
	int a, b;
	String alph;

	public Typing(int a, int b, String alph) {
		this.a = a;
		this.b = b;
		this.alph = alph;
	}

	@Override
	public int compareTo(Typing o) {
		if (this.b == o.b) {
			return this.a - o.a;
		}
		return this.b - o.b;
	}

}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/17254
