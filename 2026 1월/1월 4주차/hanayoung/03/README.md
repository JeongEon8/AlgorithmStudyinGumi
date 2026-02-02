# [백준 - S3] 10655. 마라톤 1

## ⏰  **time**
50분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 초기값 설정, N이 3보다 크거나 같다는 걸 보장받았기때문에 문제없음!
2. visited[i][0]은 건너뛴 적 없는 세계, visited[i][1]은 건너뛴 적 있는 세계에서의 거리값
```java
        visited[1][0] = Math.abs(points[1].y - points[0].y) + Math.abs(points[1].x - points[0].x);
        visited[2][0] = Math.abs(points[2].y - points[1].y) + Math.abs(points[2].x - points[1].x) + visited[1][0];
        visited[2][1] = Math.abs(points[2].y - points[0].y) + Math.abs(points[2].x - points[0].x);
```
3. [i][0]은 건너뛴 적 없는 경우이므로 visited[i-1][0]에 points[i]에서 points[i-1]까지의 거리 더한 값
4. [i][1]은 건너뛴 적 있는 경우이므로, 건너뛴 적 없는 세계의 i-2번째에서 건너뛰어 오는 경우와 건너뛴 적 있는 세계에서 i-1번째에서 건너오는 경우 중 작은 값을 가지는 것이 가장 작을 수 있는 경우이므로 두 개의 값 중 작은 값으로 할당  
```java
        for(int i = 3; i < N; i++) {
            int dist = Math.abs(points[i].y - points[i-1].y) + Math.abs(points[i].x - points[i-1].x);
            visited[i][1] = Math.min(visited[i-1][1] + dist, 
        visited[i-2][0]+ Math.abs(points[i].y - points[i-2].y) + Math.abs(points[i].x - points[i-2].x));
            visited[i][0] = visited[i-1][0] + dist;
        }
```
5. N-1번째에서 더 작은 값 출력
```java
System.out.println(Math.min(visited[N-1][1], visited[N-1][0]));
```
## :black_nib: **Review**
- 개큰 시간초과와의 싸움.... 후 겨우 dp로 해결! 별의별짓을 다했지만,, dp로 해야했던

## 📡 Link
https://www.acmicpc.net/problem/10655
