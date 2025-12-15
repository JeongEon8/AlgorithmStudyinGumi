# [백준 - G5] 12852. 1로 만들기 2

## ⏰  **time**
4시간

## :pushpin: **Algorithm**
dp

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. dp와 parent를 이용해서 연산횟수를, parent에는 이어지는 값을 넣기
```java
        dp = new int[N+1];
        parent = new int[N+1];
```
2. X가 1이면 dp[1]에 0을 넣어 반환. dp값이 -1이 아니라면 값이 할당된 것이므로 해당 값 반환.
3. X-1, X/3, X/2 중 가능한 경우들의 연산횟수 중 가장 작은 값을 찾아서 그 값을 dp에 할당하고 그 값을 이어지는 다음 값을 next로 받아서 parent에 할당
```java
public static int recur(int X) {
        if(X == 1) return dp[1] = 0;

        if(dp[X] != -1) return dp[X];

        int min = recur(X-1);
        int next = X - 1;

        if(X % 3 == 0) {
            int t = recur(X/3);
            if(t < min) {
                min = t;
                next = X/3;
            }
        }

        if(X % 2 == 0) {
            int t = recur(X/2);
            if(t < min) {
                min = t;
                next = X/2;
            }
        }
        dp[X] = min +1;
        parent[X] = next;

        return dp[X];
    }
```
6. N부터 시작해서 1이 될 때까지 반복하며 parent[cur]로 이어지는 값 찾기
```java
       int cur = N;
        while (true) {
            sb.append(cur).append(' ');
            if (cur == 1) break;
            cur = parent[cur];
        }
```


## :black_nib: **Review**
- dp 어렵다 거기다가 뭔가 생각해야할 게 추가돼서 어려웠다

## 📡**Link**
- https://www.acmicpc.net/problem/12852
