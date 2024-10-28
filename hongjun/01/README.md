# [백준 - G4] 14502. 연구소

## ⏰ **time**

50분

## :pushpin: **Algorithm**
브루트포스, bfs


## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
1. 벽을 3개 세울 수 있으니까 0으로 된 곳들의 좌표를 모두 구해서 배열에 저장함.
2. 조합으로 0인 좌표 중에서 3개를 뽑아서 1로 바꿔줌.
3. 그 상태로 2인 곳을 찾아서 BFS 실행
4. 실행 후 0인 곳의 개수를 센다.
5. 1로 바꾼 곳을 다시 0으로 바꾸고 조합으로 3개 뽑은 좌표를 다시 1로 바꿔준다.
6. bfs 반복해서 실행하고 남은 0의 개수가 가장 많은 경우의 수를 출력

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1120