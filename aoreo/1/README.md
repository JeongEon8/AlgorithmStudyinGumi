# [SWEA - D4] 1249. [S/W 문제해결 응용] 4일차 - 보급로
 
## ⏰  **time**
약 2시간

## :pushpin: **Algorithm**
bfs + 우선순위 큐

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. column, row, 소요 시간을 담은 Cost class 생성
2. 2차원 배열 visited에 방문 여부 저장
3. 타입 Cost인 PriorityQueue의 comparator 람다식 작성 통해 소요시간이 작은 순으로 정렬
4. queue에 방문할 노드들 추가(add)
5. queue가 비지 않을 때까지 반복하며, 방문할 경우, 노드 제거(poll)
6. 상하좌우 탐색하며 방문할 노드의 column과 row의 값이 유효하며, 방문하지 않은 노드일 경우에만 방문.
7. 도착지점에 도달할 경우, queue를 비우고 answer에 값을 저장.

## :black_nib: **Review**
- 처음에는 Queue를 사용하는 bfs로 접근했는데, 크기가 100인 테스트케이스를 실행할 때 heap memory 사용 가능한 영역을 초과해버렸다..

- class를 생성해서 원하는 대로 Comparator를 쓰고 싶어서 class를 정의했는데 둬야 할 위치가 헷갈려서 여러 번 시도했다... 저 위치 빼고는 다 오류 발생..

- 오랜만에 알고리즘 문제를 풀었더니 완전 오래 걸렸다 ..........

## 📡**Link**
- https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV15QRX6APsCFAYD&categoryId=AV15QRX6APsCFAYD&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=1&&&&&&&&&&
