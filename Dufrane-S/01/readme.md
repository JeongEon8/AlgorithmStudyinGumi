# [백준- S5] 18511. 큰 수 구성하기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
DFS, 완탐

## ⏲️**Time Complexity**
$O(2^N)$

## :round_pushpin: **Logic**
- K가 3이기 때문에 모두 탐색해서 구현
  
```java
    private static void dfs(int a, String s) {
        if (!s.isEmpty()) {
            int now = Integer.parseInt(s);
            if (now > max) return;
            if (now > answer) answer = now;
        }

        for (int i = 0; i < n; i++) {
            dfs(a + 1, s + list.get(i));
        }
    }
```

## :black_nib: **Review**
원소 사용 횟수 제한이 없음에 주의
## 📡**Link**
- https://www.acmicpc.net/problem/18511
