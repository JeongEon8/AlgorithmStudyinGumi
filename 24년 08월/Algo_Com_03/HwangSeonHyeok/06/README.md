# [백준 - g3] 1600. 말이 되고픈 원숭이

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

사방탐색 + 나이트의 행마 8방향을 너비 우선 탐색하여 풀었다.  
나이트 행마이동은 최대횟수가 정해져 있으므로 visited에 나이트 횟수를 몇번 사용하고 방문한건지도 기록해야한다.

```cpp
static int[] dW = { 1, 0, -1, 0, 2, 2, 1, -1, -2, -2, -1, 1 };
static int[] dH = { 0, 1, 0, -1, -1, 1, 2, 2, 1, -1, -2, -2 };

q.add(new Monkey(0, 0, 0, 0));
visited[0][0][0] = true;
while (!q.isEmpty()) {
    Monkey m = q.poll();
    if (m.W == destW && m.H == destH) {
        ans = Math.min(ans, m.step);
        break;
    }
    for (int i = 0; i < 4; i++) {
        int nextW = m.W + dW[i];
        int nextH = m.H + dH[i];
        if (monkeyCheck(nextW, nextH) && !visited[nextH][nextW][m.k]) {
            q.add(new Monkey(nextW, nextH, m.k, m.step + 1));
            visited[nextH][nextW][m.k] = true;
        }
    }
    if (m.k < k) {
        for (int i = 4; i < 12; i++) {
            int nextW = m.W + dW[i];
            int nextH = m.H + dH[i];
            if (monkeyCheck(nextW, nextH) && !visited[nextH][nextW][m.k + 1]) {
                q.add(new Monkey(nextW, nextH, m.k + 1, m.step + 1));
                visited[nextH][nextW][m.k + 1] = true;
            }
        }
    }
}

```

## :black_nib: **Review**

## 📡**Link**

- https://www.acmicpc.net/problem/1600
