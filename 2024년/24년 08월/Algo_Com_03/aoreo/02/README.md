# [SWEA - D4] 1861. 정사각형 방
 
## ⏰  **time**

40분
  
## :pushpin: **Algorithm**
bfs
  
## ⏲️**Time Complexity**
$O(N^4)$
    
## :round_pushpin: **Logic**
- bfs 활용, 모든 방을 시작점으로 탐색
- 범위 내이며, 이동할 위치의 방 숫자가 현재 방 숫자보다 1 크다면 queue에 추가하고 이동 방 수 1 추가
- 이동가능한 최대 방 수인 max[1]보다 moves가 크다면, 값 변경
- max[1]과 moves가 같은데, 방 번호가 더 작다면 해당 방으로 변경
  
## :black_nib: **Review**
설마 이걸 다 도나? 라는 생각에 이 방법으로 바로 접근 못했다..
  
## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV5LtJYKDzsDFAXc&categoryId=AV5LtJYKDzsDFAXc&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=1
