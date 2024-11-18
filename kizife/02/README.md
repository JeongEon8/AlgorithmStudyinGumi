# [백준] 14502. 연구소 


## ⏰ **time**
90분

## :pushpin: **Algorithm**
그래프 이론, 너비 우선 탐색 

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
벽 3개를 세우는 모든 방식을 구한다.
```java
if (count == 3) {
            safeArea(); // 안전 영역 계산
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) { // 빈 칸에 벽 설치
                    arr[i][j] = 1; // 벽 설치
                    makeWalls(count + 1);
                    arr[i][j] = 0; //벽 제거
                }
            }
        }
```

평범한 dfs로 max 넓이를 도출한다.
```java
for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && !visit[i][j]) {
                    int area = dfs(i, j);
                    if(area != -1) {
                        currentArea += area;
                    }
                }
            }
        }
```

탐색하다가 바이러스를 발견하면 바이러스가 포함된 영역이라는 것. nearByVirus로 true, false 여부 나누어 리턴한다.
```java
        visit[x][y] = true;
        int area = 1;
        boolean nearByVirus = false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m ) {
                if(arr[nx][ny] == 2) {
                    nearByVirus = true;
                } else if (!visit[nx][ny] && arr[nx][ny] == 0) {
                    int result = dfs(nx, ny);
                    if (result == -1) {
                        nearByVirus= true;
                    } else{
                        area += result;
                    }
                }
            }
        }

        return nearByVirus ? -1 : area;
```

## :black_nib: **Review**
'벽 3개를 세우는 모든 방식'을 어떻게 구현할 것인가?... 를 좀 고민하였다.
영역의 넓이나 개수를 구하는 것은 늘 하던 방식이라 어렵지 않았지만...

## 📡**Link**
https://www.acmicpc.net/problem/14502  
