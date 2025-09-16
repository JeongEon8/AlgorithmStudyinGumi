# [백준- G3] 1865. 웜홀
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
벨만-포드 알고리즘

## ⏲️ **Time Complexity**
$O(N^2E)$

## :round_pushpin: **Logic**
- `시간이 뒤로간다 == 음수 가중치다` & `다시 출발을 하였던 위치로 돌아왔을 때, 출발을 하였을 때보다 시간이 되돌아가 있는 경우가 있는지 == 음수 가중치가 존재하는지`
    ⇒ 벨만-포드 알고리즘 사용해서 음수 사이클 탐지하기
- 벨만-포드 알고리즘은 간선을 기준으로 → 간선 리스트 입력받은 후, N-1번 반복하기
  - 이후 N번째에 최단거리가 변경되면 음수 사이클이 존재하는 것
```java
static boolean goTrip() {
    boolean isChange = false;

    // 모든 정점에 대해 연결된 간선 확인
    for (int now = 1; now <= N; now++) {
        // 현재 정점과 연결된 간선 확인
        for (Edge next : edgeList[now]) {
            if (dist[next.v] > dist[now] + next.w) { // 더 짧은 거리가 존재하는 경우
                dist[next.v] = dist[now] + next.w;
                isChange = true;
            }
        }
    }
    return isChange;
}
```

## :black_nib: **Review**
벨만-포드 알고리즘은 아직 헷갈림.. 시뮬 돌려보면서 해봐야 할 듯

## 📡 **Link**
- https://www.acmicpc.net/problem/1865
