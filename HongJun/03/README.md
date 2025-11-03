# [백준- S2] 4963. 섬의 개수
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 그래프 탐색

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 입력받은 2차원 수열에서 1인 것을 찾으면 그 좌표를 시작으로 BFS 탐색을 한다.
- BFS 탐색을 하면서 방문처리 했다는 것을 0으로 표시한다. (1을 0으로 바꿈)
- bfs가 끝나면 카운팅을 해준다.
- 수열에 1이 없을 때까지 bfs 돌리면 된다.
  
```python

```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/4963
