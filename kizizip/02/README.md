# [백준 - S3] 26169. 세 번 이내에 사과를 먹자 

## ⏰ **time**
25분

## :pushpin: **Algorithm**
그래프 이론, dfs, 백트래킹 

## ⏲️**Time Complexity**
O(n^2)

## :round_pushpin: **Logic**
1. 시작 위치에 사과가 있는지 체크 
```java
int startApple;
        if (map[r][c] == 1) {
            startApple = 1;
        } else {
            startApple = 0;
        }
```

2. 사과 2개 이상 먹었거나, 3번 이상 이동했으면 종료
```java
        if (apples>=2) return true;
        if (count>=3) return false;
```

3. 4방탐색으로 평범한 dfs를...
```java
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx<0 || nx>=5 || ny<0 || ny>=5) continue;
            if (visited[nx][ny] || map[nx][ny] == -1) continue; 

            visited[nx][ny]= true;

            int nextApples = apples;
            if (map[nx][ny] ==1) nextApples++;

            if (dfs(nx, ny, count+1, nextApples)) return true;

            visited[nx][ny] = false; //백트래킹: 방문처리 해제
        }
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/26169
