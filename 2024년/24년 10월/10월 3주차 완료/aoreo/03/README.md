# [백준 - 골드 4] 14502.연구소
 
## ⏰  **time**
5시간 ... 그 이상?

## :pushpin: **Algorithm**
조합, dfs

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**
1. 조합으로 벽 세울 3군데 찾기
2. 벽 세울 수 있는 리스트를 돌며 바이러스 사방향 돌며 전파시키기
3. 전파 후의 map의 2인 지점 개수 찾아서 안전 영역 찾기
4. Math.max로 최대 안전 영역 수 저장하기

## :black_nib: **Review**
- 뽑을 수 있는 3군데의 모든 리스트를 저장하는 게 아니고 찾을 때마다 dfs 돌리는 게 나은 선택이었을 거 같지만... 고칠 기력 없어서 돌렸는데 통과했당
- 예전에 공통문제일 때부터 풀고싶어서 시도했는데 이번에 겨우 풀었넹
- map을 clone해서 했어야했는데 하나로 계속 했더니 자꾸 틀렸었다

## 📡 Link
https://www.acmicpc.net/problem/14502
