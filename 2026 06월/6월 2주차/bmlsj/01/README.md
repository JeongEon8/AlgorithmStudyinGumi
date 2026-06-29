# [PGS - Lv2] 01\_무인도 여행

## ⏰**time**

30min

## :pushpin: **Algorithm**

BFS

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

이웃한 구역의 숫자를 모두 합해서 정렬하는 문제.
백준 구역나누긴가.. 비슷한 문제였는데 그립다 백준아

```java
static void func(int x, int y, int n, int m) {

    visited[x][y] = true;
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[] {x, y});

    while(!queue.isEmpty()) {

        int[] curr = queue.poll();
        x = curr[0];
        y = curr[1];

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if (!visited[nx][ny] && map[nx][ny] != 'X') {
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
                cnt += map[nx][ny] - '0';
            }
        }
    }
}
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/154540>
