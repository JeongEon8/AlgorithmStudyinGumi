# [백준 - g3] 11779. 최소비용 구하기 2

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그래프 이론
- 최단 경로
- 데이크스트라

## :round_pushpin: **Logic**

경로를 기록해야하므로 출발지, 목적지, 비용, 경로를 저장하는 class를 만들고 다익스트라 알고리즘을 사용했다.

경로를 저장할 class는 다음과 같이 작성하였다.
route끼리 합칠때는 첫 route의 끝에서 edge를 한개 더 간 to.to까지므로 이를 저장하고 route에 to만 추가해준다.

```java
static class Route implements Comparable<Route>{
	int from, to, cost;
	List<Integer> route;
	public Route(int from, int to, int cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost;
		this.route = new ArrayList<>();
		route.add(from);
		if(from!=to)
			route.add(to);
	}

	public Route(Route from, Route to) {
		super();
		this.from = from.from;
		this.to = to.to;
		this.cost = from.cost+to.cost;
		route = new ArrayList<Integer>();
		route.addAll(from.route);
		route.add(this.to);
	}

	@Override
	public int compareTo(Route o) {
		return this.cost-o.cost;
	}
}
```

우선순위 큐를 사용한 다익스트라 알고리즘으로 목적지까지의 최단 비용을 구한다.

```java
PriorityQueue<Route> pq = new PriorityQueue<>();
pq.add(minRoute[start]);
while(!pq.isEmpty()) {
	Route r = pq.poll();
	if(r.cost>minRoute[r.to].cost)continue;
	for(Route next : eList[r.to]) {
		if(r.cost+next.cost<minRoute[next.to].cost) {
			minRoute[next.to] = new Route(r,next);
			pq.add(minRoute[next.to]);
		}
	}
}
```

## :black_nib: **Review**

지금와서 보니 Route.from은 거의 사용을 안했다.  
설계할때 좀 더 생각했으면 빼도될 부분.

## 📡**Link**

https://www.acmicpc.net/problem/11779
