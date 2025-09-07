# [백준 - G5] 23747. 와드

## ⏰ **time**

35분

## :pushpin: **Algorithm**

- 구현
- 그래프 이론
- 그래프 탐색
- 시뮬레이션
- 너비 우선 탐색
- 격자 그래프
- 플러드 필
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
와드를 설치할 때는 그 지점의 영역이 이미 와드로 밝혀진 영역이 아니면 bfs로 탐색하면서 시야를 밝힌다.  
모든 이동이 종료하고 종료한 칸과 상하좌우칸까지 시야를 밝힌다.
```java
for (char action : actions) {
    if (action == 'W') {
        if (ans[currentR][currentC] == '.')
            continue;
        char current = isekai[currentR][currentC];
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(currentR, currentC));
        ans[currentR][currentC] = '.';
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = p.row + dy[i];
                int nextC = p.column + dx[i];
                if (inRange(nextR, nextC) && ans[nextR][nextC]=='#' && current == isekai[nextR][nextC]) {
                    ans[nextR][nextC] = '.';
                    q.add(new Point(nextR, nextC));
                }
            }

        }
    } else {
        int dir = 0;
        if (action == 'D') {
            dir = 1;
        } else if (action == 'L') {
            dir = 2;
        } else if (action == 'R') {
            dir = 3;
        }
        currentR += dy[dir];
        currentC += dx[dir];
    }
}
ans[currentR][currentC] = '.';
for (int i = 0; i < 4; i++) {
    int tmpR = currentR + dy[i];
    int tmpC = currentC + dx[i];
    if (inRange(tmpR, tmpC)) {
        ans[tmpR][tmpC] = '.';
    }
}
```  
## :black_nib: **Review** 
## 📡**Link**
https://www.acmicpc.net/problem/23747