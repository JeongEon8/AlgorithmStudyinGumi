# [백준 - G5] 15989. 1, 2, 3 더하기 4

## ⏰  **time**
60분

## :pushpin: **Algorithm**
다이나믹 프로그래밍

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 테스트케이스를 입력받으며 가장 큰 값 저장
```java
        for(int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            tc[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tc[i]);
        }
```
2. max까지 확인하므로 max+1 크기, 1,2,3까지이므로 크기 4 배열 생성
```java
int[][] dp = new int[max+1][4];
```
3. 초기값 할당
```java
dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
```
3. 4부터 max까지 확인, 1로 끝나는 것은 i-1과 동일한 값([1]) , 2로 끝나는 것은 [i-2][1]에 2를 붙이거나 [i-2][2]에 2를 붙이는 경우, 3으로 끝나는 것은 [i-3][1], [i-3][2], [i-3][3]에 붙이는 경우
```java
       for(int i = 4; i < max+1; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }
```
4. 테스트 케이스 돌면서 sb에 append
```java
        for(int i = 1; i < N+1; i++) {
            sb.append(dp[tc[i]][1]+dp[tc[i]][2]+dp[tc[i]][3]).append("\n");
        }
```

## :black_nib: **Review**
- dp 점화식 세우기 넘 어려워서 골골

## 📡**Link**
- https://www.acmicpc.net/problem/15989
