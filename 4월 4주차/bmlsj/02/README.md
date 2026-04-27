# [Leet - Medium] 79. Word Search

## ⏰**time**

30분

## :pushpin: **Algorithm**

DFS, 백트래킹

## ⏲️**Time Complexity**

$O(3^L)$

## :round_pushpin: **Logic**

1. 현재 위치의 문자가 단어의 idx번째 문자와 일치하는지 확인한다.
2. 단어의 마지막 문자까지 모두 일치하면 탐색을 종료하고 true를 반환한다.
3. 경로가 실패하면 방문 표시를 해제하고(백트래킹) 다른 경로를 탐색한다.

```java
static String dfs(int x, int y, String str, int idx, char[][] board) {

    if (idx == words.length - 1) {
        return str;
    }

    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx < 0 || ny < 0 || nx >= m || ny >= n)
            continue;

        if (!visited[nx][ny] && board[nx][ny] == words[idx + 1]) {

            String result = dfs(nx, ny, str + words[idx + 1], idx + 1, board);
            if (result != null && result.equals(new String(words))) {
                return result;
            }
        }
    }

    visited[x][y] = false;
    return null;

}
```

## :black_nib: **Review**

리트 코드..? 흠..

## 📡 Link

<https://leetcode.com/problems/word-search?envType=problem-list-v2&envId=depth-first-search>
