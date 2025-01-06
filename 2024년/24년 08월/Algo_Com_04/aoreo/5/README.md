# [SWEA D4] 7465. 창용 마을 무리의 개수

## ⏰  **time**
30분

## :pushpin: **Algorithm**
bfs, 그래프?

## ⏲️**Time Complexity**
$O(N+M)$
<br/>N은 노드, M은 간선

## :round_pushpin: **Logic**
1. 연결 관계를 ArrayList를 이용해 저장, 양측 모두 저장
2. 가능한 연결된 관계들을 모두 탐색하며, 하나의 queue가 하나의 무리이므로 시작하기 전 count 증가시킴
3. 방문하지 않은 노드만 탐색
4. 연결된 모든 관계를 탐색하며 queue에 추가하고, 방문처리
5. 연결되지 않은 사람(방문되지 않은 사람)을 찾아 count로 추가

## :black_nib: **Review**
서로 모르는 경우가 많을 수도 있다는 점을 고려 못했다
 
## 📡 **URL**
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AWngfZVa9XwDFAQU&categoryId=AWngfZVa9XwDFAQU&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=2
