# [백준 - s4] 1491. 나선

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 구현
- 시뮬레이션

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

문제에 주어진 조건대로 모든 배열을 돌았을 때 끝나는 위치를 출력한다

```cpp
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };
    int total = n * m - 1;
    int cnt = 0;
    int dir = 0;
    int x = 0, y = 0;
    while (cnt++ != total) {
        visited[y][x] = true;
        if (x + dx[dir % 4] < 0 || y + dy[dir % 4] < 0 || x + dx[dir % 4] == n || y + dy[dir % 4] == m || visited[y + dy[dir % 4]][x + dx[dir % 4]]) {
            dir++;
        }
        x += dx[dir % 4];
        y += dy[dir % 4];
    }

```

## :black_nib: **Review**

- 배열의 남서쪽을 0, m-1이라 생각하고 풀어서 오래걸렸다. 남서쪽이 0,0이라고 주어진 문제.

## 📡**Link**

- https://www.acmicpc.net/problem/1491
