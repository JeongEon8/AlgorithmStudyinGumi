# [백준 - G5] 14585. 사수빈탕

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
x와 y는 +방향으로만 갈 수 있으므로 각 바구니에 도착할때는 x+y개의 사탕이 녹아있다. 이를 고려하여 좌표에 사탕의 갯수를 기록하고 dp로 (x-1,y), (x,y-1)중 더 사탕을 많이먹고 온 경우를 dp배열에 기록한다. 300,300좌표까지 모두 돌면 답을 구할 수 있다.
```java
graph = new int[301][301];
for (int i = 0; i < n; i++) {
    st = new StringTokenizer(in.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    graph[y][x] = Math.max(m - x - y,0);
}
dp = new long[301][301];
dp[0][0] = graph[0][0];
for (int i = 1; i <= 300; i++) {
    dp[0][i] = dp[0][i - 1] + graph[0][i];
    dp[i][0] = dp[i - 1][0] + graph[i][0];
}
for (int i = 1; i <= 300; i++) {
    for (int j = 1; j <= 300; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + graph[i][j];
    }
}
```  
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/14585
