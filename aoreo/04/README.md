# [백준 - 골드 4] 16234.인구 이동
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 이중 for문을 통해 모든 지역을 탐색하며, 방문하지 않은 지점일 경우, queue에 추가한다.
2. 사방향을 돌며, 차이가 L이상 R이하일 경우 queue에 추가한다.
3. queue에 추가되는 지점들은 모두 인구수를 관리할 변수에 더해준다.
4. 해당 지점을 연합인 지역들을 담은 ArrayList에 추가한다.
5. 인구 이동이 발생할 경우, 연합의 개수를 증가시킨다.
6. 인구 이동이 아예 발생하지 않은 경우 while문을 빠져나온다
7. 인구 이동이 발생했었을 경우, 연합개수만큼 반복문을 돌며, 한 연합에 속해있는 지역들을 탐색하며, 인구수를 변경한다.


## :black_nib: **Review**
- 변수가 많아서 헷갈렸던 문제... 혼자 먼 길 가버리기

## 📡 Link
[https://www.acmicpc.net/problem/16234](https://www.acmicpc.net/problem/16234)
