# [백준 - S2] 28015. 영역 색칠

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
가로로 한줄에서 0이외의 수로 연결된 것을 한 영역으로 본다. 각 영역에서 배경색을 칠하고 나머지 색으로 칠하면 된다. 배경색은 더 많이 나온 색으로 칠하므로 배경색으로 칠하는 횟소(1회) + 더 적은 색 수의 횟수로 영역을 다 칠할 수 있다.
```java
for (int i = 0; i < n; i++) {
    memo[1] = 0;
    memo[2] = 0;
    if (section[i][0] != 0) {
        memo[section[i][0]]++;
    }
    for (int j = 1; j < m; j++) {
        int priorColor = section[i][j - 1];
        int color = section[i][j];
        if (color == 0 && Math.max(memo[1], memo[2]) != 0) {
            memo[0] += 1 + Math.min(memo[1], memo[2]);
            memo[1] = 0;
            memo[2] = 0;
        } else if (color != 0 && priorColor != color) {
            memo[color]++;
        }
    }
    if (Math.max(memo[1], memo[2]) != 0)
        memo[0] += 1 + Math.min(memo[1], memo[2]);
}
```  
## :black_nib: **Review** 
처음엔 큐를 사용할 고민을 했으나 규칙을 찾아 풀었다.
## 📡**Link**
https://www.acmicpc.net/problem/28015