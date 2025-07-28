# [백준 - 골드 4] 1976. 여행 가자

## ⏰  **time**
2시간

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^2 + MN)$

## :round_pushpin: **Logic**
1. ArrayList를 요소로 가지는 배열 생성하여 추가
```java
        ArrayList<Integer>[] maps = new ArrayList[N];
        boolean[][] checked = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            if(maps[i] == null) maps[i] = new ArrayList<>();
            
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    if(maps[j] == null) maps[j] = new ArrayList<>();
                    maps[i].add(j);
                }
            }
        }
```
2. 이동가능한 정보를 담을 변수 생성
```java
        ArrayList<Integer>[] visited = new ArrayList[N];

        for(int i = 0; i < N; i++) {
            visited[i] = new ArrayList<>();
        }
```
3. 거쳐서 넘어갈 수 있는 노드 탐색
```java
        for (int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            for (Integer e : maps[i]) {
                q.add(e);
            }

            while (q.size() > 0) {
                int cur = q.poll();
                if (checked[i][cur] == false) {
                    checked[i][cur] = true;
                    visited[i].add(cur);
                    q.addAll(maps[cur]);
                }
            }
        }
```
4. i번째에서 i+1번째로 어떻게든 갈 수 있다면, visited[i]에 담겨있을 것임, 같은 도시에서 같은 도시로 이동할 경우는 visited에 처리를 따로 하지 않았으므로 if문으로 해결
```java
        for(int i = 0; i < M-1; i++) {
            int cur = path[i];
            if(visited[cur].contains(path[i+1]) == false && cur != path[i+1]) {
                answer = "NO";
                break;
            }
        }
```

## :black_nib: **Review**
- 생각보다 우당탕탕.. 양방향으로 넣으면 왜 안되는거지....잉...아직도 이해가 잘 안된다

## 📡 Link
https://www.acmicpc.net/problem/1976
