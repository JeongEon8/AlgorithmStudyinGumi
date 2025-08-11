# \[백준 - 실버 1] 7562. 나이트의 이동

## ⏰  **time**

25분

## \:pushpin: **Algorithm**

BFS (너비 우선 탐색)

## ⏲️**Time Complexity**

\$O(I^2)\$

* $I$: 체스판 한 변의 길이
* 최악의 경우 모든 좌표를 한 번씩 방문.

## \:round\_pushpin: **Logic**

1. **입력**

   * 테스트 케이스 수 $T$
   * 각 테스트 케이스마다 체스판 크기 $I$, 현재 좌표 `(nowX, nowY)`, 목표 좌표 `(targetX, targetY)` 입력.
2. **초기화**

   * `reset()`으로 `visited`, `arr`, 큐를 초기화.
3. **BFS 탐색**

   * 시작 좌표를 큐에 넣고 `visited` 체크.
   * 큐에서 좌표를 꺼내서 8가지 나이트 이동 방향(`dx`, `dy`) 탐색.
   * 범위 내이고 아직 방문하지 않았다면 큐에 넣고, `arr[다음좌표] = arr[현재좌표] + 1`로 이동 횟수 기록.
4. **종료 조건**

   * 목표 좌표에 도달하면 해당 좌표의 `arr` 값을 출력 후 BFS 종료.

```cpp
void bfs(int x, int y) {
    q.push({ x,y });
    visited[x][y] = 1;

    while (!q.empty()) {
        int a = q.front().first;
        int b = q.front().second;
        q.pop();

        if (a == targetX && b == targetY) {
            cout << arr[a][b] << "\n";
            return;
        }

        for (int i = 0; i < 8; i++) {
            int na = a + dx[i];
            int nb = b + dy[i];

            if (0 <= na && 0 <= nb && na < I && nb < I && !visited[na][nb]) {
                q.push({ na,nb });
                visited[na][nb] = 1;
                arr[na][nb] = arr[a][b] + 1;
            }
        }
    }
}
```

## \:black\_nib: **Review**

* BFS 기본 문제지만, 말 이동 경로가 8방향이라 구현 실수가 나올 수 있음.
* 매 테스트 케이스마다 배열과 큐를 초기화하는 `reset()` 함수가 꼭 필요했다.
* 범위 조건 체크를 철저히 안 하면 런타임 에러가 발생할 수 있음.

## 📡 Link

[https://www.acmicpc.net/problem/7562](https://www.acmicpc.net/problem/7562)
