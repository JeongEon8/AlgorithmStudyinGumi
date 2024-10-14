# [백준 - 골드 5] 7569. 토마토
 
## ⏰  **time**
4시간

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**
1. 모든 토마토가 익었는지 확인하여, 익은 경우 0 반환
2. 익지 않은 토마토가 있는 경우, 익은 토마토를 찾아서, 해당 토마토의 주변 탐색
3. 사방향과 위아래를 탐색하며, 익지 않은 토마토가 방문한 적 없거나, 기존 visited 값이 더 크다면 visited 값 넣어주고, queue에 추가
4. N -> M -> H 를 탐색하며 모두 익었는지 확인하여, 익지 않았을 경우 -1 반환. 익었을 경우 가장 큰 값 반환
   
## :black_nib: **Review**
로직이 꼬여서 좀 오래걸렸던 문제.. 토마토 싫어요 😒😒

## 📡 Link
https://www.acmicpc.net/problem/7569
