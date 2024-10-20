# [백준 - G2] 1202. 보석 도둑

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 자료 구조
- 그리디 알고리즘
- 정렬
- 우선순위 큐

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

정렬을하고 가장 가방 크기가 작은것부터 가방 크기 이하의 보석을 우선순위 큐에넣고 다 넣으면 우선순위 큐에서 가장 가치가 있는 보석을 꺼내서 가방에 넣어주는식으로 푼다.

```java
Arrays.sort(jArray);
Arrays.sort(bp);
int bpidx = 0;
long ans = 0;
PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
	@Override
	public int compare(Long o1, Long o2) {
		return (int) (o2 - o1);
	}
});
for (int i = 0; i < n; i++) {
	if (bp[bpidx] < jArray[i].weight) {
		while (bpidx < m && bp[bpidx] < jArray[i].weight) {
			if (!pq.isEmpty()) {
				ans += pq.poll();
			}
			bpidx++;
		}
		if (bpidx == m)
			break;
	}
	pq.add(jArray[i].value);

}
while (bpidx < m && !pq.isEmpty()) {
	ans += pq.poll();
	bpidx++;
}

```

## :black_nib: **Review**

냅색처럼 생긴 그리디 문제.
배낭에 보석이 한개밖에 안들어간다.

## 📡**Link**

https://www.acmicpc.net/problem/1202
