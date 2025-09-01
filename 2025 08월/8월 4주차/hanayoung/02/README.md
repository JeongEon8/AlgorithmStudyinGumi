# [백준 - G5] 12865. 평범한 배낭

## ⏰  **time**
60분

## :pushpin: **Algorithm**
배낭문제

## ⏲️**Time Complexity**
$O(N*K)$

## :round_pushpin: **Logic**
1. 2차원 배열 생성, 물품의 수, 무게 의미
```java
int[][] dp = new int[N+1][K+1]; // 물품의 수, 무게
```
2. 물건의 무게와 가치를 담을 클래스 생성
```java
    static class Object {
        int weight;
        int value;

        public Object(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
```
3. N개의 물건을 1부터 N까지 순환하며 넣는 경우와 넣지 않는 경우 탐색
```java
        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < K+1; j++) {
                if(j < arr[i].weight) { 
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i].weight]+arr[i].value);
                }
            }
        }
```

## :black_nib: **Review**
- 배낭문제랑 친해지기..어렵당

## 📡**Link**
- https://www.acmicpc.net/problem/12865
