# [SWEA - D4] 1258. [S/W 문제해결 응용] 7일차 - 행렬찾기

## ⏰  **time**
6시간

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 모든 maps를 돌며, 방문한 적 없고, 0이 아닌(화학물질인) 곳이라면 dfs 시작점으로 돌리기
2. dfs 내에서는, 사방향으로 돌며, 방문한 적 없고, 범위 내이며, 화학물질인 곳이면 방문처리하고 가장 멀리 간 값인 largeX, largeY보다 nextX, nextY가 클 경우 변경.
3. 해당 nextX, nextY로 dfs 또 돌기
4. 빠져나왔을 때 largeX, largeY와 초기 시작점인 i, j와 비교하여 사각형의 크기 구하기.
5. 우선순위큐에 사각형들의 모든 정보 넣고, 사각형의 크기 비교, 같을 경우, 작은 행부터 꺼내도록 설정.
6. 하나씩 꺼내며, String에 붙이고 반환.


## :black_nib: **Review**
각 사각형의 크기를 어떻게 저장하지? 에서 굉장히 오래걸렸고 오답이 많이 나왔다..
그리고 초기화 안해줘서 냅다 배열 짱 많이 출력해버리기 😥
마지막으로 기껏 써둔 예외처리 냅다 주석처리해서 또 틀려버리기 😥😥

## 📡 Link
[https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWNcJ2sapZMDFAV8](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18LoAqItcCFAZN)
