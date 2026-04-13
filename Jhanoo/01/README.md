# [백준 - 골드 4] 1987. 알파벳

## ⏰**time**

29분

## :pushpin: **Algorithm**

- DFS (백트래킹)
- 비트마스킹

## ⏲️**Time Complexity**

$O(4^{L})$ (이론상)  
`L`은 최대 이동 길이(알파벳 종류 수로 최대 26).  
실제는 비트마스크로 이미 사용한 알파벳을 빠르게 가지치기하여 훨씬 줄어듭니다.

## :round_pushpin: **Logic**

1. 보드를 입력받고 시작점 `(0,0)`의 알파벳을 비트마스크로 표시합니다.  
   `A~Z`를 0~25번 비트로 사용합니다.

```java
int startMask = 1 << (board[0][0] - 'A');
dfs(0, 0, startMask, 1);
```

2. DFS 상태는 `(r, c, mask, depth)`로 관리합니다.
   - `mask`: 지금까지 지나온 경로에서 사용한 알파벳 집합
   - `depth`: 현재 경로 길이

```java
static void dfs(int r, int c, int mask, int depth) {
    answer = Math.max(answer, depth);
    ...
}
```

3. 상하좌우로 이동할 때 범위를 벗어나면 건너뜁니다.  
   다음 칸 알파벳의 비트를 `nextBit`로 만들고, 이미 `mask`에 포함되어 있으면(중복 알파벳) 이동하지 않습니다.

```java
int nextBit = 1 << (board[nr][nc] - 'A');
if ((mask & nextBit) != 0) continue;
```

4. 이동 가능한 칸이면 `mask | nextBit`로 알파벳 사용 상태를 갱신하고 깊이를 1 늘려 재귀 호출합니다.

```java
dfs(nr, nc, mask | nextBit, depth + 1);
```

5. 모든 탐색이 끝난 뒤 `answer`가 말이 지날 수 있는 최대 칸 수입니다.

```java
System.out.println(answer);
```

## :black_nib: **Review**

-

## 📡 Link

https://www.acmicpc.net/problem/1987
