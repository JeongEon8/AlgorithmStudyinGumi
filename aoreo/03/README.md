# [SWEA - 모의] 2105. 디저트 카페
 
## ⏰  **time**
5시간

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(N^2*3^N)$

## :round_pushpin: **Logic**
1. 사각형으로 도는 게 불가능한 시작점들을 제외하고 모든 점을 시작점으로 두고 탐색하기
2. dfs 함수 파라미터로 이동 방향, 다음 지점, 먹은 디저트 개수, 꺾인 횟수를 넘기기
3. 사각형을 이루기 위해서는 3번만 꺾여야 하므로, 꺾인 횟수를 넘김
4. 이동 방향은 본인과 반대방향만 제외하고 다 탐색하기
5. 가장 많이 먹은 디저트 개수를 반환

## :black_nib: **Review**
- 시간초과 😥😥 시작점을 제외하는 꼼수로 겨우 통과....

## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu
