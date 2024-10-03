# [백준 - g4] 2458. 키 순서

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 플로이드 워셜

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**

모든 정점에 대해서 자신에게 올 수 있거나 자신이 도착할 수 있는 정점이면 자신이 몇 위인지 알 수 있다.  
모든 정점들의 연결 확인이 필요하므로 플로이드 워셜 알고리즘을 사용하였다.

```cpp
for (int i = 1; i <= n; i++) {
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    graph[from][to] = Math.min(graph[from][to], graph[from][i] + graph[i][to]);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == max && graph[j][i] == max) {
                    flag = false;

                }
            }
            if (flag)
                ans++;
        }

```

## :black_nib: **Review**

## 📡**Link**

- https://www.acmicpc.net/problem/2458
