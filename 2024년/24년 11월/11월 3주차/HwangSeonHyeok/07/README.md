# [백준 - S3] 3231. 카드놀이

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 애드 혹

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
카드객체에 값과 index 정보를 기록하고 값에 대해 오름차순으로 정렬하는 우선순위 큐에 넣고 하나씩 카드를 꺼내서 이전 카드보다 index가 작아지면 박수를 치면된다.

```java
	static class Card implements Comparable<Card> {
		public Card(int value, int index) {
			this.value = value;
			this.index = index;
		}

		int value, index;

		@Override
		public int compareTo(Card o) {
			return this.value - o.value;
		}

	}
	Card current = pq.poll();
	while (!pq.isEmpty()) {
		Card next = pq.poll();
		if (current.index > next.index) {
			ans++;
		}
		current = next;
	}

```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/3231
