# [백준 - 골드 3] 2206. 벽 부수고 이동하기

## ⏰  **time**

4시간

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
1. bfs로 가능한 길 탐색
2. 벽을 부술 수 있는 경우 벽을 부수고, 벽을 부순 세계관으로 진입
3. 벽을 부순 후로는 쭉 벽을 부순 세계관 유지하며 queue.add
4. 최종 좌표에 도착할 경우 queue의 좌표에 해당하는 값 반환.

## :black_nib: **Review**
벽을 부순 세계와 부수지 않은 세계로 나뉘어진다는 걸 생각하기가 힘들었당..
그리고 dfs가 하고싶었다......시간초과 어택
 
## 📡 **URL**
https://www.acmicpc.net/problem/2206
