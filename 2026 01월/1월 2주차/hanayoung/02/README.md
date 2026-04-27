# [백준 - S1] 2178. 미로 탐색

## ⏰  **time**
10분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N*M)$

## :round_pushpin: **Logic**
1. String으로 들어오는 값을 하나씩 떼서 숫자로 배열에 저장
```java
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for(int j = 0; j < str.length(); j++) {
                maps[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
            }
        }

```
2. queue가 빌 때까지 반복. 하나씩 꺼내서 사방향을 탐색해서 이동할 수 있고 방문한 적 없으면 업데이트하고 queue에 추가
```java
        while(q.size() > 0) {
            Point cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }
```
3. (N,M)까지 가는 데에 걸린 칸 수이므로 visited[N-1][M-1] 값 출력
```java
System.out.println(visited[N-1][M-1]);
```
## :black_nib: **Review**
- 익숙한 BFS 알고리즘 문제 야호

## 📡 Link
https://www.acmicpc.net/problem/2178
