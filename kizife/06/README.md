# [백준] 1697. 숨바꼭질   
 
## ⏰  **time**
30분 

## :pushpin: **Algorithm**
bfs 

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
- 현재 위치에서 -1, +1, *2를 적용한 위치로 이동할 수 있는지 확인
- 이동한 위치가 유효하고, 아직 방문하지 않은 경우에만 큐에 추가
- 이동한 위치의 방문 시간을 현재 위치 방문 시간 + 1로 설정
- ```java
visited[now - 1] = visited[now] + 1;
  ```
- 목표위치 도달 불가한 경우 -1 반환 


## :black_nib: **Review**
- 구현이 어려운 문제는 아닌데 큐에 넣고 뺀다는 게 머리에 그려지지 않았다...!

## 📡**Link**
- https://www.acmicpc.net/problem/1697
