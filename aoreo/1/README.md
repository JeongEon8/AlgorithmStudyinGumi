# [SWEA - D4] 1226. [S/W 문제해결 기본] 7일차 - 미로1
 
## ⏰  **time**
1시간 20분

## :pushpin: **Algorithm**
DFS + 백트래킹

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 맵을 구성하는 배열 생성
2. 시작점과 종료지점 저장
3. 상하좌우를 탐색하며 이동가능 할 경우, visited값과 start 지점 수정된 dfs 함수 호출
4. 마지막 지점에 도달할 경우 1 리턴
5. 도달할 수 없는 지점일 경우 재귀함수에서 빠져나와 visited값 수정


## :black_nib: **Review**
- 괜히 DFS + 백트래킹으로 풀고싶어서 더 오래걸렸당..
- 갈 수 있는 지점은 0뿐만아니라 2와 3도 있는데 이걸 체크안해줬더니 앞으로 가지 못한다고 판단하는 큰 문제 발생...

## 📡 Link
[https://www.acmicpc.net/problem/4673](https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV14vXUqAGMCFAYD&categoryId=AV14vXUqAGMCFAYD&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=1)
