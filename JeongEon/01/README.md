# [백준 - 실버 2] 1058. 친구

## ⏰**time**
15분

## :pushpin: **Algorithm**
BFS (깊이 제한 탐색)

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**
1. `relationship[i][j]`가 `'Y'`면 친구 관계(간선)로 본다.
2. 각 사람 `v`에 대해 BFS를 수행하되, **깊이(depth) 2까지만** 확장한다.
   * depth 0: 자기 자신
   * depth 1: 친구
   * depth 2: 친구의 친구(2-친구)
3. BFS 중 방문하지 않은 사람을 처음 발견하면 `visit` 체크 후 `friends++`로 카운트한다.
   * 시작점 `v`는 `visit[v]=1`로 미리 방문 처리해서 자기 자신 제외
4. 한 사람의 BFS가 끝나면 `max_friends`를 갱신한다.
```
bfs(v):
  visit[] = 0
  queue에 (v, 0) push
  visit[v] = 1
  friends = 0

  while queue not empty:
    (now, depth) pop
    if depth > 1: continue   // depth 2까지만 세기 위해

    for i in 0..N-1:
      if relationship[now][i] == 'Y' and visit[i] == 0:
        visit[i] = 1
        friends++
        queue push (i, depth+1)

  max_friends = max(max_friends, friends)
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/1058](https://www.acmicpc.net/problem/1058)
