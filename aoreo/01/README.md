# [SWEA - D4] 1251. [S/W 문제해결 응용] 4일차 - 하나로 
 
## ⏰  **time**

60분
  
## :pushpin: **Algorithm**

그래프, 프림, 크루스칼 알고리즘
  
## ⏲️**Time Complexity**

$O(N^2 log N))$
    
## :round_pushpin: **Logic**
- Edge Class를 정의하여, index와 거리를 함께 관리
- 프림 알고리즘에 따라, 임의의 시작점에서 갈 수 있는 노드들을 거리값과 함께 저장.
- 이미 방문한 인덱스의 경우 pass
- PriorityQueue로 가장 가까운 거리부터 뽑아서 탐색
- 더 이상 추가되는 노드가 없을 경우, 다 탐색했다고 판단하여 queue를 clear하여 반복문 빠져나옴.
  
## :black_nib: **Review**
다익스트라와 프림, 크루스칼이 헷갈린다.. 
  
## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV15StKqAQkCFAYD&categoryId=AV15StKqAQkCFAYD&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=1
