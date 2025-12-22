
# [백준- G2] 1202. 보석 도둑

## ⏰  **time**
1시간

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O((N+K) log N)$

## :round_pushpin: **Logic**

1. 보석은 무게 기준 낮은 것(오름차순), 무게가 같으면 가격이 높은 것(내림차순)을 선택한다.
2. 가방은 무게가 작은 것(오름차순)부터 선택한다.
3. 각 가방에 들어갈 수 있는 보석만 PQ에 넣고, 그 중 가격이 최대인 것(여기서 한번 더 정렬! 내림차순)을 선택한다.



```java
Arrays.sort(bags);
PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.v - a.v); // 가격 내림차순

long price = 0;
int idx = 0;
for (int i = 0; i < K; i++) {
	while (idx < N && jewel[idx].m <= bags[i]) {
		pq.offer(jewel[idx++]);
	}
	
	if (!pq.isEmpty()) {
		price += pq.poll().v;
	}
}
```


## :black_nib: **Review**

처음에 보석을 PQ에 넣고 1번 정렬만 했었는데 시간초과와 오답이 반복됐다.아래처럼 보석 전체를 뽑아서 배낭을 조회하면 모든 경우의 수를 반복할 수 있기 때문에, O(N×K)가 될 수 있으므로 주의할 것!


## 📡**Link**
- https://www.acmicpc.net/problem/1202

