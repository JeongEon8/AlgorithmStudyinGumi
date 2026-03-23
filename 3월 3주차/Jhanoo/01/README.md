# [백준 - 골드 5] 13549. 숨바꼭질 3

## ⏰**time**

19분

## :pushpin: **Algorithm**

- 0-1 BFS (Deque)
- 최단 거리 (가중치 그래프)

## ⏲️**Time Complexity**

$O(\text{MAX})$  
(\(\text{MAX} = 100000\), 각 정점이 덱에서 처리되며 간선 relax는 상수번)

## :round_pushpin: **Logic**

1. 위치는 `0 ~ 100000` 범위로 보고 `dist[pos]`를 시작점 `N`에서 해당 위치까지의 최단 시간으로 둡니다.  
   순간이동 `x -> 2x`는 비용 0, 걷기 `x -> x-1`, `x+1`은 비용 1입니다.

```java
int[] dist = new int[100_001];
final int INF = Integer.MAX_VALUE;
Arrays.fill(dist, INF);
dist[N] = 0;

ArrayDeque<Integer> q = new ArrayDeque<>();
q.offer(N);
```

2. 덱에서 현재 위치 `x`를 꺼내 3가지 이동을 relax 합니다.
   - 비용 0(순간이동): 더 짧아지면 `offerFirst`로 덱의 앞에 넣습니다.
   - 비용 1(좌/우 이동): 더 짧아지면 `offer`로 덱의 뒤에 넣습니다.

```java
int nx = x * 2;
if (nx <= 100000 && dist[nx] > dist[x]) {
    dist[nx] = dist[x];
    q.offerFirst(nx);
}

nx = x - 1;
if (nx >= 0 && dist[nx] > dist[x] + 1) {
    dist[nx] = dist[x] + 1;
    q.offer(nx);
}

nx = x + 1;
if (nx <= 100000 && dist[nx] > dist[x] + 1) {
    dist[nx] = dist[x] + 1;
    q.offer(nx);
}
```

3. 덱에서 꺼낸 `x`가 목표 `K`가 되면, 그때의 `dist[K]`가 최단 시간이므로 바로 출력합니다.

```java
if (x == K) {
    System.out.println(dist[x]);
    return;
}
```

## :black_nib: **Review**

- 바쁘다바빠..

## 📡 Link

https://www.acmicpc.net/problem/13549
