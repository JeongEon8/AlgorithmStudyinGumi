# [PGS - Lv2] 03_N-Queen

## ⏰**time**

30분

## :pushpin: **Algorithm**

DFS

## ⏲️**Time Complexity**

$O(2^N)$

## :round_pushpin: **Logic**

1. **유효성 검사**
   - 퀸을 배치할 때마다 이전 행(`0`부터 `depth-1`)에 놓인 퀸들과 비교하여 가로, 세로, 대각선 상에 겹치는 변수가 없는지 확인
2. **백트래킹**
   - 유효성 검사를 통과한 경우에만 다음 행(`depth + 1`)으로 진입
   - `depth == n`에 도달하면 모든 퀸을 안전하게 배치한 것이므로 `answer`를 1 증가

```java
class Solution {
    static int[] board;
    static int answer;

    public static int solution(int n) {
        board = new int[n];
        backTracking(0, n);
        return answer;
    }

    private static void backTracking(int depth, int n) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[depth] = i;
            if (valid(depth)) {
                backTracking(depth + 1, n);
            }
        }
    }

    private static boolean valid(int i) {
        for (int j = 0; j < i; j++) {
            if (board[i] == board[j]) return false;
            if (Math.abs(i - j) == Math.abs(board[i] - board[j])) return false;
        }
        return true;
    }
}
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/12952>
