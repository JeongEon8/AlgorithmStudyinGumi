# [백준 - G5] 2294. 동전 2

## ⏰  **time**
50분

## :pushpin: **Algorithm**
dp

## ⏲️**Time Complexity**
$O(N*k)$

## :round_pushpin: **Logic**
1. 동전 가짓수를 담을 변수, dp 계산에 사용할 배열, 최댓값으로 사용할 변수 선언
```java
    static int[] dp;
    static HashSet<Integer> coins;
    static final int INF = 1000000;
```
2. 재귀함수, 0보다 작거나 같으면 0 반환
3. dp[val] != 0 을 통해, 이미 확인한 값이면 바로 반환
4. 가장 최솟값을 찾기 위해 min을 설정해두고, 재귀함수 반환값과 min을 비교하여 최솟값 찾기
```java
static int recur(int val) {
        if (val <= 0) {
            return 0;
        }
        if (dp[val] != 0) {
            return dp[val];
        }

        int min = INF;
        for (int coin : coins) {
            if (val >= coin) {
                min = Math.min(min, recur(val - coin) + 1);
            }
        }

        return dp[val] = min;

    }
```
5. dp[k]가 INF라면, 불가능한 값이므로 -1 반환
```java
        recur(k);

        System.out.println(dp[k] == INF ? -1 : dp[k]);
```


## :black_nib: **Review**
- 재귀와 dp랑 친해지기 중이나 어렵다 잉잉

## 📡**Link**
- https://www.acmicpc.net/problem/2294
