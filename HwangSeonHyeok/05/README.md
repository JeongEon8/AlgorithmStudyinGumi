# [백준 - G4] 1715. 카드 정렬하기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 문자열
- 정렬

## ⏲️**Time Complexity**

$O(nlogn)$

## :round_pushpin: **Logic**

우선순위 큐에서 2개씩꺼내서 더하고 다시 큐에 넣어주는식으로 반복한다.

```java
for (int i = 1; i < n; i++) {
	Long sum = pq.poll() + pq.poll();
	ans += sum;
	pq.add(sum);
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1715
