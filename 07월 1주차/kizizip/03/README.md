# [백준 - S3] 2606. 바이러스 

## ⏰ **time**
10분

## :pushpin: **Algorithm**
그래프 이론, dfs

## ⏲️**Time Complexity**
O(n^2)

## :round_pushpin: **Logic**
1. `map[x][y] = map[y][x] = 1` 연결 정보 저장
2. `dfs(1)` 1번부터 모든 곳 방문. 방문할 때마다 count++
3. 1번 컴퓨터 제외하고 출력 


## :black_nib: **Review**  
기초부터 다시...

## 📡**Link**
https://www.acmicpc.net/problem/2606
