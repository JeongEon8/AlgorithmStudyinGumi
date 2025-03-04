# [백준 - G4] 14502. 연구소
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- BFS, 브루트포스

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 빈칸인 좌표들 중에서 3개를 조합으로 선택하고 벽으로 바꾼다.
2. 바이러스인 좌표들을 queue에 넣어서 4방향 BFS를 돌린다.
3. 다 수행하고 난 뒤에 0인 곳의 개수를 저장한다.
4. 그 중에서 가장 큰 값을 출력력
```python
# 빈칸 중에서 3개를 조합으로 뽑아서 저장
wall_index = [i for i in range(len(wall))]
pick3 = list(combinations(wall_index, 3))
```

## :black_nib: **Review**

## 📡 Link
https://www.acmicpc.net/problem/14502
