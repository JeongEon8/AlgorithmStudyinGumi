# [백준 - S5] 2161. 카드1

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 자료 구조
- 큐

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
queue의 앞 부분을 덱의 윗장이라고 생각하고 한장을 바닥에 내려놓고(출력) 한장을 덱의 가장 아래(큐의 뒤)로 옮기는 동작을 반복한다.

```java
	while (!dq.isEmpty()) {
		System.out.print(dq.poll() + " ");
		if (dq.isEmpty())
			break;
		dq.add(dq.poll());
	}
```

## :black_nib: **Review**
deque를 사용하긴했는데 그냥 queue랑 똑같이썼다.

## 📡**Link**

https://www.acmicpc.net/problem/2161
