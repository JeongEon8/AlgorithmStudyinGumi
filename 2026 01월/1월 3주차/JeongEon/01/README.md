# [백준 - 실버 2] 21736. 헌내기는 친구가 필요해

## ⏰ **Time**
20분

## :pushpin: **Algorithm**
BFS

## ⏲️ **Time Complexity**

* $O(N * M)$

## :round_pushpin: **Logic**

1. 캠퍼스 지도를 2차원 배열로 입력받고, 시작 위치 `'I'`를 저장한다.
2. 시작 위치에서 BFS를 수행하며 상·하·좌·우로 이동한다.
3. 이동 시 다음 조건을 만족해야 한다.

   * 캠퍼스 범위를 벗어나지 않음
   * 벽(`'X'`)이 아님
   * 아직 방문하지 않은 칸
4. 탐색 중 사람이 있는 칸(`'P'`)을 만나면 카운트를 증가시킨다.
5. BFS 종료 후, 만난 사람이 없다면 `"TT"`, 있다면 만난 사람 수를 출력한다.

```
queue에 시작 위치(I) 삽입
visited 처리

while queue not empty:
    현재 위치 pop
    4방향 탐색
        범위 체크
        벽(X) 체크
        방문 여부 체크
        사람이면 카운트 증가
        queue에 push 및 visited 처리
```

## :black_nib: **Review**
-

## 📡 Link

[https://www.acmicpc.net/problem/21736](https://www.acmicpc.net/problem/21736)
