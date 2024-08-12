# [SWEA - D3] 1225. 암호생성기
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
큐, 덱

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
맨 앞 숫자를 빼서 1~5를 빼고 다시 뒤에 넣는 문제이다.
- 1부터 5까지 빼서 뒤로 이동하는게 한 사이클이고 5를 빼면 다시 1로 돌아간다.
- 뺀 값이 0이나 0보다 작아지면 끝난다.
- 덱을 사용해서 popleft하고 append하면 더 시간이 줄지 않을까?


## :black_nib: **Review**
사이클 도는 조건을 잘못 이해해서 시간이 좀 걸린 듯 하다.


## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD