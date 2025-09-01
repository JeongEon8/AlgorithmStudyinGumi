# \[백준 - 실버 2] 1058. 친구

## ⏰  **time**

15분

## \:pushpin: **Algorithm**

BFS(깊이 제한) + 그래프 탐색

## ⏲️**Time Complexity**

\$O(N^2)\$

* $N \le 50$. 각 정점에서 깊이 2까지 BFS → 간선 수가 많아도 상수에 가깝게 제한됨.

## \:round\_pushpin: **Logic**

1. 인접 행렬 `relationship[i][j]`에서 `'Y'`는 친구, `'N'`은 아님.
2. 각 사람 `v`를 시작점으로 **깊이 2까지** BFS 수행:

   * 큐 원소는 `(정점, 깊이)`. 시작점은 `(v, 0)`에서 시작.
   * 꺼낸 노드의 깊이가 2를 초과하면 스킵.
   * 아직 방문하지 않았고 `'Y'`인 모든 이웃을 방문 표시 후 큐에 `(이웃, 깊이+1)`로 삽입.
   * 방문 체크를 이용해 **중복 집계 방지**, 시작점 자신은 제외됨(시작 시 `visit[v]=1`).
3. 방문한 사람 수(= 친구 + 친구의 친구)를 `friends`로 집계하여 `max_friends` 갱신.

```cpp
void bfs(int v){
    memset(visit, 0, sizeof(visit));
    queue<pair<int,int>> q;
    q.push({v, 0});
    visit[v] = 1;
    int friends = 0;

    while(!q.empty()){
        auto [now, d] = q.front(); q.pop();
        if(d > 1) continue;                 // 깊이 2까지만
        for(int i=0; i<N; i++){
            if(relationship[now][i] == 'Y' && !visit[i]){
                visit[i] = 1;               // 중복 방지
                friends++;                   // v의 2-친구까지 카운트
                q.push({i, d+1});
            }
        }
    }
    max_friends = max(max_friends, friends);
}
```

## \:black\_nib: **Review**

* 문제 포인트는 “**2-친구**”를 정확히 세는 것. 깊이 제한 BFS가 가장 깔끔했다.
* 시작점을 먼저 방문 처리해 자기 자신을 제외하는 트릭이 편했다.

## 📡 Link

[https://www.acmicpc.net/problem/1058](https://www.acmicpc.net/problem/1058)
