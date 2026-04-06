# [백준 - 골드1] 13460. 구슬 탈출2

## ⏰ **time**

120분

## :pushpin: **Algorithm**

- BFS
- 구현

## ⏲️**Time Complexity**

$O(N^2 \cdot M^2)$

## :round_pushpin: **Logic**

각 방향으로 기울일 때마다 두 구슬을 각각 while문으로 벽이나 구멍을 만날 때까지 이동시키고, 이동 거리(dist)를 이용해 충돌 시 위치를 조정한다.
방문 처리는 (R, B)의 좌표를 모두 포함한 4차원 배열로 관리하여 중복 상태를 방지한다.

1. 각 구슬별로 while문을 통해 굴린다.

```java
// 구슬 이동 (한 방향으로 끝까지 굴리기)
while (map[nx + dx[d]][ny + dy[d]] != '#') {
    nx += dx[d];
    ny += dy[d];
    dist++;

    if (map[nx][ny] == 'O') break;
}
```

1. 만약 더 멀리 서 왔다면, 한칸 전으로 되돌린다.

```java
if (rnx == bnx && rny == bny) {
    if (rDist > bDist) {
        rnx -= dx[d];
        rny -= dy[d];
    } else {
        bnx -= dx[d];
        bny -= dy[d];
    }
}
```

## :black_nib: **Review**

풀었던건데 왜 못풀겠지? 어려웡

## 📡**Link**

<https://www.acmicpc.net/problem/13460>
