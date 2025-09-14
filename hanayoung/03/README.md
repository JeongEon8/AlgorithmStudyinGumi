# [백준 - G3] 2146. 다리 만들기

## ⏰  **time**
70분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(K × N²)$

## :round_pushpin: **Logic**
1. 같은 섬인지 판단하는 함수, 한 번만 확인하고 배열에 각각 저장해두고 사용
2. 빙산 문제(백준 2573)와 유사하게, 모든 섬을 방문하되, 이어서 방문할 수 없다면 다른 섬으로 판단, chunks 배열에 어떤 섬인지 저장
```java
    static void checkSameIsland(int[][] maps, int N, ArrayList<Point> islands) {
        boolean[][] visited = new boolean[N][N];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Point> q = new LinkedList<>();
        int count = 1;

        for (Point p : islands) {
            if (visited[p.x][p.y] == false) {
                q.add(p);
                visited[p.x][p.y] = true;
                chunks[p.x][p.y] = count;

                while (q.size() > 0) {
                    Point cur = q.poll();

                    for (int i = 0; i < 4; i++) {
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                            continue;
                        }

                        if (maps[nx][ny] == 1 && visited[nx][ny] == false) {
                            q.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                            chunks[nx][ny] = count;
                        }
                    }
                }
                count++;
            }

        }
    }
```
3. 모든 섬을 방문하고, 시작점은 visited[p.x][p.y] 값을 1로 설정. 바다인 경우(다리를 건설할 수 있으니) 방문한 적 없거나 더 가까운 경로인 경우 업데이트하고 큐에 추가
4. 섬이고, 같은 섬이 아닌 경우(chunks 배열로 판단), 현재까지의 다리길이인 visited[cur.x][cur.y] -1(초기 시작값이 1이었으므로 1 빼기)와 answer의 최솟값을 answer로 업데이트
```java
        for (Point p : islands) {
            Queue<Point> q = new LinkedList<>();
            q.add(p);
            visited[p.x][p.y] = 1;

            while (q.size() > 0) {
                Point cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    if (maps[nx][ny] == 0 && (visited[nx][ny] == 0 || visited[nx][ny] > visited[cur.x][cur.y] + 1)) {
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                        q.add(new Point(nx, ny));
                    }

                    if (maps[nx][ny] == 1 && chunks[nx][ny] != chunks[p.x][p.y]) // 0이고 가까운 곳만 다리를 짓되, 1이 나타나면 도착했으니 값 비교하기
                    {
                        answer = Math.min(answer, visited[cur.x][cur.y] - 1);
                    }
                }
            }
        }
```

      
## :black_nib: **Review**
- 빙산 풀다 넘어와서 매번 체크하다가 시간 초과 맞아버리기 .. 이것도 뭔가 복잡하게 생각해서 넘 어려웠다.. bfs야 얼른 친해지자

## 📡**Link**
- https://www.acmicpc.net/problem/2146
