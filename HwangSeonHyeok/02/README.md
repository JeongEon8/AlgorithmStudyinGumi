# [백준 - S1] 33939. 부도덕한 그래프 (Easy)

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그래프 이론
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**
각각의 정점마다 자신에게 들어오는 정점들을 기록한다.  
정점들마다 부모 둘을 골라 둘이 간선이 있는지를 체크하고 있으면 부도덕한 관계다.
```java
int ans = 0;
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
        if (graph[i][j]) {
            for (int k = j + 1; k <= n; k++) {
                if (graph[i][k] && !(graph[j][k] || graph[k][j])) {
                    ans++;
                }
            }
        }
    }
}
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/33939