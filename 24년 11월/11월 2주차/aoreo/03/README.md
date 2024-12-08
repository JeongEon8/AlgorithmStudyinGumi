# [백준 - G5] 10026. 적록색약
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N*M)$

## :round_pushpin: **Logic**
1. 적록색약인 경우와 아닌 경우 두 가지 탐색
2. 적록색약이 아닌 경우, 같은 색일 때만 같은 영역이므로, 방문한 적 없으며 maps[p.x][p.y]와 maps[nx][ny]가 같은 경우에 queue에 추가
3. 적록색약인 경우, R과 G를 같은 영역으로 보므로, 방문한 적 없으며 maps[p.x][p.y]가 B인 경우는 maps[nx][ny]도 B인 경우에, maps[p.x][p.y]가 R, G인 경우 maps[nx][ny]도 R, G인 경우에 queue에 추가
4. 두 경우 모두, queue를 생성할 경우에 area를 +1하여 영역 수를 세어 비교

## :black_nib: **Review**
- 간단한 bfs 문제였다 야호

## 📡 Link
https://www.acmicpc.net/problem/10026
