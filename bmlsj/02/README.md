# [백준- G2] 1781. 컵라면

## ⏰  **time**
1시간 30분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**

1. 처음 입력 받은 값을 데드라인이 작은 수부터 정렬하고, 같으면 컵라면이 큰 수로 정렬한다.
2. 여기서 조건이 맞는 값들을 배열에 넣어야 한다. 이때 배열 사이즈는 문제를 푸는 데 걸린 수랑 동일하므로 데드라인보다 작아야 한다. 
    => 배열을 정렬할 수 있어야하고 추가, 삭제가 $O(logn)$ 이어야 하므로 PQ 사용
3. PQ를 라면이 작은 수부터 정렬한다.
4. 데드라인이 PQ의 크기보다 크면 PQ에 추가
5. 데드라인이 PQ의 크기와 같고, PQ의 젤 앞의 라면 수보다 크면
    젤 앞의 문제를 제거하고 새 문제를 추가한다.
6. PQ의 각 라면수를 더한다.

```java
PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
	return a[1] - b[1]; // 컵라면이 작은 수부터
});

Arrays.sort(arr, new Comparator<int[]>() {
	@Override
	public int compare(int[] o1, int[] o2) {
		if (o1[0] == o2[0]) { // 데드라인이 같으면
			return o2[1] - o1[1]; // 컵라면은 큰 수부터
		} else {
			return o1[0] - o2[0]; // 데드라인은 작은 수부터 정렬
		}
	}
});

for (int i = 0; i < N; i++) {
	 if (arr[i][0] > pq.size()) {
		// 데드라인이 size보다 크면 들어올수 잇다
		pq.offer(new int[] { arr[i][0], arr[i][1] });
	} else if (arr[i][0]== pq.size() && pq.peek()[1] < arr[i][1]) {
		pq.remove();
		pq.offer(new int[] { arr[i][0], arr[i][1] });
	}
}
```


## :black_nib: **Review**

라면 먹고싶다


## 📡**Link**
- https://www.acmicpc.net/problem/1781

