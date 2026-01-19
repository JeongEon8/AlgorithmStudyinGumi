# [백준 - 실버 1] 11403. 경로 찾기
 
## ⏰**time**
30분

## :pushpin: **Algorithm**
DFS (깊이 우선 탐색), 그래프 탐색

## ⏲️**Time Complexity**
$O(N^3)$

* 각 정점마다 DFS 수행: $O(N + E)$
* 인접 행렬 기준 최악의 경우 $E = N^2$
* 전체적으로 $O(N^3)$

## :round_pushpin: **Logic**
1. 인접 행렬을 입력받아, 간선이 존재하는 경우 인접 리스트 형태로 그래프를 구성한다.
2. 각 정점 `i`를 시작점으로 DFS를 수행한다.
3. DFS를 통해 도달 가능한 모든 정점을 `visit` 배열에 표시한다.
4. DFS 종료 후 `visit` 배열을 출력하면, 정점 `i`에서 각 정점으로의 경로 존재 여부를 알 수 있다.
5. 모든 정점에 대해 위 과정을 반복한다.

```
for i = 0 to N-1:
    visit 배열 초기화
    dfs(i)
    visit 결과 출력
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/11403](https://www.acmicpc.net/problem/11403)
