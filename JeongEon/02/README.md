# \[백준 - 골드 4] 1197. 최소 스패닝 트리

## ⏰  **time**

20분

## \:pushpin: **Algorithm**

크루스칼(Kruskal) + 유니온 파인드(Disjoint Set)

## ⏲️**Time Complexity**

\$O(E \log E)\$

* 간선 정렬: $O(E \log E)$
* `find/union`: 경로 압축으로 거의 $O(1)$ 평균

## \:round\_pushpin: **Logic**

1. 모든 간선을 `(cost, {u, v})` 형태로 벡터에 저장하고 **비용 오름차순 정렬**!
2. `parent[i] = i`로 **유니온 파인드 초기화**.
3. 정렬된 간선을 앞에서부터 순회하며

   * 두 정점의 루트가 다르면 **채택**하고 `union(u, v)` 수행, `result += cost`.
   * 같은 집합이면 **사이클**이므로 건너뜀.
4. 간선을 모두 보거나, `V-1`개가 채택되면 종료 → `result`가 MST 가중치 합.

```cpp
int find(int x){ return parent[x]==x ? x : parent[x]=find(parent[x]); }
void uni(int x,int y){ x=find(x); y=find(y); parent[y]=x; }
bool sameparent(int x,int y){ return find(x)==find(y); }

sort(v.begin(), v.end()); // cost 기준
for(int i=1;i<=vertex;i++) parent[i]=i;

int result=0;
for(auto &e: v){
    int c=e.first, u=e.second.first, vtx=e.second.second;
    if(!sameparent(u, vtx)){
        uni(u, vtx);
        result += c;
    }
}
cout << result;
```

## \:black\_nib: **Review**

* 크루스칼은 구현이 간단하고 직관적이라 실수 포인트가 적다.
* `find`에 **경로 압축**을 꼭 넣어야 큰 입력에서 시간 초과 방지!
* 간선 구조를 `(cost, {u, v})`로 두면 정렬 & 접근이 깔끔했다.

## 📡 Link

[https://www.acmicpc.net/problem/1197](https://www.acmicpc.net/problem/1197)
