# [SWEA - D4] 1824. 혁진이의 프로그램 검증

## ⏰ **time**

35분

## :pushpin: **Algorithm**

- 구현
- 그래프 탐색
- 너비 우선 탐색

## :round_pushpin: **Logic**

State엔 좌표, 방향, 메모리 값이 들어가야한다.  
visited는 어떤 상태에서 방문했는지가 들어가야하므로 visited[r][c][4][16]로 구현하고 체크한다.
?는 4방향 모두 진행하는 분기를 추가한다.

```java
   static boolean bfs() {
        boolean flag = false;
        Queue<State> q = new ArrayDeque<>();

        q.add(new State(0, -1, 0, 0));

        while (!q.isEmpty()) {
            State cur = q.poll();
            int nextX = cur.x + dx[cur.dir];
            int nextY = cur.y + dy[cur.dir];
            int nextDir = cur.dir;
            int nextMemory = cur.memory;
            if (nextX < 0) {
                nextX = c - 1;
            } else if (nextX == c) {
                nextX = 0;
            } else if (nextY < 0) {
                nextY = r - 1;
            } else if (nextY == r) {
                nextY = 0;
            }
            if (graph[nextY][nextX] == '@') {
                flag = true;
                break;
            }
            if (visited[nextY][nextX][nextDir][nextMemory])
                continue;
            visited[nextY][nextX][nextDir][nextMemory] = true;
            // dir 0:우, 1:하, 2:좌, 3:상
            char nextChar = graph[nextY][nextX];
            if (nextChar == '<') {
                nextDir = 2;
            } else if (nextChar == '>') {
                nextDir = 0;
            } else if (nextChar == '^') {
                nextDir = 3;
            } else if (nextChar == 'v') {
                nextDir = 1;
            } else if (nextChar == '_') {
                nextDir = nextMemory == 0 ? 0 : 2;
            } else if (nextChar == '|') {
                nextDir = nextMemory == 0 ? 1 : 3;
            } else if (nextChar >= '0' && nextChar <= '9') {
                nextMemory = graph[nextY][nextX] - '0';
            } else if (nextChar == '+') {
                nextMemory++;
                if (nextMemory == 16)
                    nextMemory = 0;
            } else if (nextChar == '-') {
                nextMemory--;
                if (nextMemory == -1)
                    nextMemory = 15;
            }

            if (nextChar == '?') {
                for (int i = 0; i < 4; i++) {
                    visited[nextY][nextX][i][nextMemory] = true;
                    q.add(new State(nextY, nextX, i, nextMemory));
                }
            } else {
                q.add(new State(nextY, nextX, nextDir, nextMemory));
            }

        }

        return flag;

    }

```

## :black_nib: **Review**

조건이 굉장히 지지분하게 많은 문제  
출력을 YES/NO로 해야하는데 Yes/No로해서 1번틀렸다.  
TC가 69개나 되는데 다 맞는거 체크하는동안 눈치못챔..

## 📡**Link**

- https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4yLUiKDUoDFAUx
