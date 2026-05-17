# [PGS - Lv2] 03\_숫자 변환하기

## ⏰**time**

30분

## :pushpin: **Algorithm**

BFS

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. `x`를 `y`로 변환하는 문제
2. 최소 연산 횟수기 때문에 BFS로 풀이

```java
static int calc(int x, int y, int n) {

    Queue<int[]> q = new LinkedList<>();
    boolean[] visited = new boolean[1000001];

    q.offer(new int[]{x, 0});
    visited[x] = true;


    while (!q.isEmpty()) {

        int[] cur = q.poll();

        int num = cur[0];
        int cnt = cur[1];

        if (num == y) {
            return cnt;
        }

        int[] next = {num + n, num * 2, num * 3};

        for(int nx: next) {
            if (nx <= y && !visited[nx]) {
                visited[nx] = true;
                q.offer(new int[]{nx, cnt + 1});
            }
        }

    }

    return -1;
}
```

## :black_nib: **Review**

처음에 dfs도 써봤는데 x, y가 $10^6$ 까지여서 시간초과가 계속 발생했다.

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/154538>
