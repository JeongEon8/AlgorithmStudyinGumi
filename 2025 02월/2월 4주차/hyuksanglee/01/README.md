# [백준 - S2] 11279. 최대힙

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 우선순위 큐
## ⏲️**Time Complexity**

$O(N log N)

## :round_pushpin: **Logic**
- 우선순위 큐 생성
  	- 최대힙으로 ollections.reverseOrder()으로 역순으로 바꾸준다.
- x가 0이면 큐 안에 최대값을 출력하는데 아무것도 없으면 0을 출력

```java
	PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
```

## :black_nib: **Review**
- 코드만 알면 쉬운 코드네요

## 📡**Link**

https://www.acmicpc.net/problem/11279
