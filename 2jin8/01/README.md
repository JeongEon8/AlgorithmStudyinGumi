# [백준- G2] 16946. 벽 부수고 이동하기 4
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(NM)$

## :round_pushpin: **Logic**
- 분리 집합 개념을 사용해서 이동할 수 있는 공간들을 하나의 그룹으로 묶기
- 각 그룹에 속하는 칸의 개수를 저장한 뒤, 벽이 있는 위치에서 4방향을 확인하여 해당 그룹에 포함된 수를 더하면 됨
  - 이때, 같은 그룹을 여러 번 더하지 않도록 그룹 방문 처리를 해줘야 함
```java
static int makeGroup(int x, int y, int groupNumber) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{x, y});
    visited[x][y] = true;

    int count = 0;
    while (!queue.isEmpty()) {
        int[] now = queue.poll();
        record[now[0]][now[1]] = groupNumber;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = now[0] + dx[i];
            int ny = now[1] + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if (map[nx][ny] == 1 || visited[nx][ny]) {
                continue;
            }

            queue.offer(new int[]{nx, ny});
            visited[nx][ny] = true;
        }
    }
    return count;
}
```

## :black_nib: **Review**
N과 M 범위를 잘 보고 생각해서 풀자

## 📡**Link**
- https://www.acmicpc.net/problem/16946
