# [백준 - S1] 6118. 숨바꼭질 

## ⏰ **time**

20분

## :pushpin: **Algorithm**

-그래프 이론
-그래프 탐색
-너비 우선 탐색
## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
가장 거리가 먼 헛간 중 번호가 가장 작은 헛간을 찾아야 하므로 Step(거리) 우선순위 큐를 사용하였다.  
더 우선순위 큐에서 더 step이 큰게 나오면 ansStep을 갱신해주고 정답 헛간 번호를 최대 값보다 크게 해준다.  
더 작은 장소가 나오면 정답 번호를 갱신해주면 답을 구할 수 있다.


```java
while (!pq.isEmpty()) {
	JaeSuGi cur = pq.poll();
	if (cur.step > ansStep) {
		ansStep = cur.step;
		ansCnt = 0;
		ansNum = n + 1;
	}
	ansCnt++;
	if (cur.num < ansNum) {
		ansNum = cur.num;
	}
	for (int next : graph[cur.num]) {
		if (!visited[next]) {
			visited[next] = true;
			pq.add(new JaeSuGi(next, cur.step + 1));
		}
	}
}
```

## :black_nib: **Review**
BFS문제

## 📡**Link**

https://www.acmicpc.net/problem/6118
