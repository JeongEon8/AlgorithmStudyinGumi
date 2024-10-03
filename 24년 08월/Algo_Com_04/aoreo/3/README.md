# [백준 - 골드 3] 14442. 벽 부수고 이동하기2

## ⏰  **time**

7시간

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
1. bfs로 가능한 길 탐색
2. 벽을 부술 수 있는 경우 벽을 부수고, 벽을 부순 세계관으로 진입
3. 벽을 부순 후로는 쭉 벽을 부순 세계관 유지하며 queue.add
4. 최종 좌표에 도착할 경우 queue의 좌표에 해당하는 값 반환.
   
#### 벽 부수고 이동하기와 유사하나 벽 부순 세계관만 증가

## :black_nib: **Review**
진짜진짜 오래 걸렸는데 이유가 출력 패턴 잘못 지켜서.........
 
## 📡 **URL**
[https://www.acmicpc.net/problem/2206](https://www.acmicpc.net/problem/14442)
