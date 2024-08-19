# [SWEA - D4] 1868. 파핑파핑 지뢰찾기
 
## ⏰  **time**

140분 (그 이상일지도...)
  
## :pushpin: **Algorithm**
bfs
  
## ⏲️**Time Complexity**
$O(N^4)$
    
## :round_pushpin: **Logic**
- countBomb을 통해 주변의 지뢰 개수 세기
- 방문한 적 없고, 지뢰가 없는 칸이고, 주변의 지뢰 개수가 0인 경우, bfs 탐색, 이 경우 이동 수는 1만 더함
- 8방향을 탐색하며, 방문한 적 없고, 지뢰가 없으며, 주변 지뢰 개수가 0인 경우 queue에 추가하고 방문 처리
- 주변 지뢰 개수가 0이상인 경우는 방문만 처리
- 아직 탐색하지 않았으며, 지뢰가 없는 곳을 탐색하여 이동 수 +1
  
## :black_nib: **Review**
변수들이 마구마구 꼬이고... 너무 복잡하게 생각하느라 잔뜩 빙글빙글 돌았다...
  
## 📡 Link
[https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV5LtJYKDzsDFAXc&categoryId=AV5LtJYKDzsDFAXc&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=1](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV5LwsHaD1MDFAXc&categoryId=AV5LwsHaD1MDFAXc&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=2)
