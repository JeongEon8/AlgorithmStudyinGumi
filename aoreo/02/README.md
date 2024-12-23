# [백준 - G5] 7576.토마토
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(n^2)$

## :round_pushpin: **Logic**
1. 처음부터 익어 있는 토마토들을 모두 queue에 저장
2. 모두 익어있을 경우 바로 0 반환
3. 상하좌우 탐색하며, 방문한 적 없거나 더 짧은 일수로 익히는 것이 가능하며, 토마토가 없는 곳이 아니라면 해당 좌표 queue에 추가하고 visited 값 할당
4. 모든 탐색 후, 한 번 더 이중 for문으로 탐색하여 토마토가 있는 곳인데도 익지 않은 토마토가 있는 경우 break하고 -1 반환
5. 모두 익었을 경우 visited의 최댓값인 answer 값 반환

## :black_nib: **Review**
- 오랜만에 bfs 문제 푸니까 새롭당...

## 📡 Link
https://www.acmicpc.net/problem/7576
