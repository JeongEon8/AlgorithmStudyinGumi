# [프로그래머스 - Lv2] 리코쳇 로봇

## ⏰  **time**
40분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N * M * (N + M))$

## :round_pushpin: **Logic**
1. 이동할 좌표, 이동횟수 담을 변수 생성
2. Board 탐색하며 시작점 찾고 q에 담기
```java
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        // queue에 x, y, 이동횟수 담기
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                if(board[i].charAt(j) == 'R') {
                    q.add(new int[]{i,j,1});
                    break;
                }
            }
        }
```
3. 꺼낸 값이 최종 지점이면 answer 업데이트 후 탈출
4. 꺼낸 값 방문 처리 후, 사방향 이동 확인, 다음 이동할 곳이 이동 못할 지점인 곳까지 진행
5. 진행할 만큼 진행 후, 방문한 적 없고 장애물지점이 아니라면 q에 추가
```java
        while(q.size() > 0) {
            int[] cur = q.poll();
            if(board[cur[0]].charAt(cur[1]) == 'G') {
                answer = cur[2] -1;
                break;
            }
            visited[cur[0]][cur[1]] = true;
            for(int i = 0; i < 4; i++) {
                int nx = cur[0];
                int ny = cur[1];
                while(nx+dx[i] >= 0 && nx+dx[i] < N && ny+dy[i] >= 0 && ny+dy[i] < M && board[nx+dx[i]].charAt(ny+dy[i]) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                if(visited[nx][ny] == false && board[nx].charAt(ny) != 'D') {
                    q.add(new int[]{nx, ny, cur[2]+1});
                }
            }
        }
```


## :black_nib: **Review**
- 완전 옛날에 파이썬으로 풀다가 만 문젠데 성장했을지도

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/169199
