# [백준 - 골드 5] 16928. 뱀과 사다리 게임

## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N+M)$

## :round_pushpin: **Logic**
1. 움직임(사다리, 뱀) 나타낼 클래스 생성
```java
    static class Move {

        int from;
        int to;
        int type;
        // 아무것도 없음: 0, 사다리: 1, 뱀: 2

        Move(int from, int to, int type) {
            this.from = from;
            this.to = to;
            this.type = type;
        }
    }
```
2. 사다리인 경우, type을 1, 뱀인 경우 type을 2, 아닌 경우 0으로 저장
3. 방문여부를 확인하며 100에 도착하면 종료
```java
        while(q.size() > 0) {
            int cur = q.poll();
            if(cur == 100) break;

            for(int i = 1; i <= 6; i++) {
                int next = cur + i;
                if(next > 100) break;

                if(maps[next].type >= 1 && visited[maps[next].to] == 0) {
                    q.add(maps[next].to);
                    visited[maps[next].to] = visited[cur] + 1;
                } else if(maps[next].type == 0 && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[cur] + 1;
                }
            }
        }
```

## :black_nib: **Review**
- BFS로 푸는 문젠지 몰랐지만..? BFS하니까 금방이넹..

## 📡 Link
https://www.acmicpc.net/problem/16928
