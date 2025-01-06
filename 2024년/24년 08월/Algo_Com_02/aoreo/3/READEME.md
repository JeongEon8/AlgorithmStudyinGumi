# [SWEA - D4] 2819. 격자판의 숫자 이어 붙이기

## ⏰  **time**
1시간

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. [0,0]부터 순회하며 dfs 호출
2. depth가 6일 경우 set에 추가 후 빠져나오기
3. 상하좌우를 순회하며 가능한 경우는 방문하여 tmp에 해당 배열의 값을 덧붙이고 depth + 1하여 dfs 호출


## :black_nib: **Review**
- HashSet 초기화를 전역적으로 했더니 1문제만 맞는 오류 발생..
- dfs 오랜만에 풀었더니 헷갈린다..
- dfs에 넘겨줄 때 tmp += arr[curX][curY]로 수정한 tmp를 넘겼더니 tmp가 계속 길어지는 문제 발생했었다..

## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV7I5fgqEogDFAXB&categoryId=AV7I5fgqEogDFAXB&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=1
