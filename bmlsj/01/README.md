
# [프로그래머스 - lv2] 도넛과 막대 그래프

## ⏰  **time**
120분

## ⏲️**Time Complexity**
$O(N + E)

## 풀이 

1. 시작노드를 구해서 시작노드에서 뻗어나가는 노드들의 사이클 수를 구하기
   - 시작 노드는 `indegree`가 0이면서 `outdegree >= 2` 인 노드
2. 시작 노드에서 뻗어 나가는 노드들의 사이클을 `findCycle` 함수로 구하기
     - 사이클이 0이면 막대 그래프
     - 사이클이 1이면 도넛 그래프
     - 사이클이 2이면 8자 그래프
3. 처음에 사이클을 구하면서 매번 `visited`를 초기화 하였는데, 시간초과가 발생
   - 어짜피 한 노드는 다른 그래프에 속할 수 없으니까 `visited`를 하나만 두어도 가능하다

- outdegree와 indegree 배열을 두어 노드별 간선 수를 기록한다.
```java
for (int[] e : edges) {
            int from = e[0];
            int to = e[1];

            graph[from].add(to);

            outdegree[from]++;
            indegree[to]++;
        }
```

- 시작 노드 구하기. outdegree가 2이상이고 indegree가 0인 노드
```java
static int findStartNode() {
        
  for(int i = 1; i <= outdegree.length; i++) {
     if (outdegree[i] >= 2 && indegree[i] == 0) {
           return i;
     }
  }
  return 0;
}
```

- 각 그래프의 수를 구하기
```java
int donut = 0;
int bar = 0;
int eight = 0;
        
int[] visited = new int[maxNode + 1]; 
int gId = 1;
for(int next: graph[startNode]) {
            
    cycleCnt = 0;
    findCycle(next, gId, visited);
    gId++;
            
    if (cycleCnt == 0) bar++;
    else if (cycleCnt == 1) donut++;
    else if (cycleCnt == 2) eight++;
}
```

## :black_nib: **Review**

아영이가 준 시련..


## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/258711

