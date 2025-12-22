# [백준- G5] 16928. 뱀과 사다리 게임
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
- BFS

## ⏲️**Time Complexity** 
O(1)

## :round_pushpin: **Logic**
- 이동했던 곳(check)을 확인하며 너비 우선 탐색 진행
- 이동하기 전에(move) 뱀과 사다리가 있는 곳인지 확인
``` java
private static int bfs() {

    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{1, 0}); // 시작칸 1, 이동횟수 0

    check[1] = true;

    while (!queue.isEmpty()) {
        int[] temp = queue.poll();
        int pos = temp[0];
        int cnt = temp[1];

        if (pos == 100) return cnt;

        for (int i = 1; i <= 6; i++) {
            int next = pos + i;
            if (next > 100 || check[next]) continue;

            int moved = move(next);
            if (!check[moved]) {
                check[moved] = true;
                queue.offer(new int[]{moved, cnt + 1});
            }
        }

    }
    return -1;
}
```


## :black_nib: **Review**
코테 공부 레츠고

## 📡**Link**
- https://www.acmicpc.net/problem/16928
