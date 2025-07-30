
# [백준- G2] 1655. 가운데를 말해요
## ⏰  **time**
50분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**
$O(logN)$

## :round_pushpin: **Logic**

- 중간값을 실시간으로 구하려면 두 개의 힙 사용
    - `maxHeap` (왼쪽): 중간값 이하 → 최대 힙
    - `minHeap` (오른쪽): 중간값 초과 → 최소 힙

- 항상 `maxHeap.size() >= minHeap.size()`
- 중간값 = `maxHeap의 top`

```java
PriorityQueue<Integer> right = new PriorityQueue<>(); // 최소 힙(중간 값 이하)
PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙

for (int i = 0; i < N; i++) {

	int input = Integer.parseInt(br.readLine());
	if (left.isEmpty() || left.peek() >= input) { // input 이 더 작을 경우
		left.offer(input);
	} else {
		right.offer(input);
	}

	// 크기 조절
	if (left.size() > right.size() + 1) {
		right.add(left.poll());
	}

	if (right.size() > left.size()) {
		left.add(right.poll());
	}

	System.out.println(left.peek());
}
```

## :black_nib: **Review**
처음에 그냥 정렬 사용했는데, $O(NlogN)$ 으로 시간초과가 발생했다.
- 우선순위 큐를 2개 사용하면 $O(logN)$ 으로 더 빠르게 가능


## 📡**Link**
- https://www.acmicpc.net/problem/1655

