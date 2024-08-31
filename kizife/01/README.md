# [백준] 2667. 단지번호붙이기 
 
## ⏰  **time**
30분 

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
196ms

## :round_pushpin: **Logic**
- 집이 있고 아직 방문하지 않은 경우, dfs로 단지 크기를 탐색하고, 크기를 리스트에 추가한다 
```java
                if (map[i][j] == 1 && !visit[i][j]) {
                    int count = dfs(i, j); // DFS로 단지 크기 탐색
                    result.add(count); // 단지 크기를 결과 리스트에 추가
```

- 새로운 좌표가 지도 안에 있고, 집이 있고, 아직 방문하지 않은 경우
```java
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    count += dfs(nx, ny); 
                }
            }
        }
        return count; // 현재 단지의 총 집의 수 반환
```

## :black_nib: **Review**
- 출력을 이상하게 해서 한참 해멨다.

## 📡**Link**
- https://www.acmicpc.net/problem/2667
