# [백준 - S2] 21736. 헌내기는 친구가 필요해

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- bfs

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

bfs로 접근 가능한 곳에 모두 접근해서 P 카운트

```
 while (!q.empty()) {
        int nowy = q.front().first;
        int nowx = q.front().second;
        q.pop();
        for (int k = 0; k < 4; k++) {
            int ny = nowy + dy[k];
            int nx = nowx + dx[k];
            if (ny < 0 || nx < 0 || ny == n || nx == m || box[ny][nx] == 'X')continue;
            if (box[ny][nx] == 'P')answer++;
            q.push({ny, nx});
            box[ny][nx] = 'X';
        }
    }

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/21736
