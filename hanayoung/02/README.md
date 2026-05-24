# [SWEA - D3] 02_최장 경로

## ⏰**time**

60분

## :pushpin: **Algorithm**

DFS

## ⏲️**Time Complexity**

$O(N!)$

## :round_pushpin: **Logic**

1. 재사용하는 변수들 초기화하는 변수 선언
   ```
    static void init(int N) {
        max = 0;
        graph = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
    }
   ```
2. dfs 함수 생성. 길이를 비교해서 가장 큰 값을 max에 저장
3. 방문하지 않은 노드라면 방문처리하고 dfs 호출 후 다시 방문안함 처리하기
```
    static void dfs(int node, int length) {
        max = Math.max(max, length);

        for(int next: graph[node]) {
            if(visited[next] == false) {
                visited[next] = true;
                dfs(next, length+1);
                visited[next] = false;
            }
        }
    }
```
4. 1번부터 N까지의 노드에 대해서 방문처리 후 dfs 호출
```
            for(int i = 1; i < N+1; i++) {
                visited = new boolean[N+1];
                visited[i] = true;
                dfs(i,1);
            }
```

## :black_nib: **Review**

- bfs로만 접근해서 왕왕 오래걸림. 백트래킹 오랜만에 봤더니 넘 헷갈리네..

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
