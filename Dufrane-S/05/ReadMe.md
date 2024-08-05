# [백준 - G5] 2589. 보물섬
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
bfs


## :round_pushpin: **Logic**
1. 모든 가능한 시작점 L마다 bfs해서 가장 먼 거리를 구해주고 모든 시작점 별 최대 거리를 계산
```
 
include <iostream>
#include <queue>


using namespace std;


int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int main() {
    int n, m;
    cin >> n >> m;
    bool done[n][m]; // 방문 체크하는 done
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            char a;
            cin >> a;
            if (a == 'W') { // 벽이면 true
                done[i][j] = true;
            } else {
                done[i][j] = false;
            }
        }
    }
    int answer=0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (!done[i][j]) {
                int newdone[n][m]; // 모든 시작점 L마다 bfs 할 때 사용할 newdone  
                int score[n][m]; // 거리를 기록하는 score

                for (int a = 0; a < n; a++) {
                    for (int b = 0; b < m; b++) {
                        newdone[a][b] = done[a][b]; //복사 및 초기화
                        score[a][b] = 0;
                    }
                }
                queue<pair<int, int>> q;
                q.push({i, j});
                newdone[i][j] = 1;
                int x,y;
                while (!q.empty()) {
                    y = q.front().first;
                    x = q.front().second;

                    q.pop();
                    for (int k = 0; k < 4; k++) {
                        int ny = y + dy[k];
                        int nx = x + dx[k];

                        if (ny < 0 || nx < 0 || ny == n || nx == m || newdone[ny][nx])continue;
                        q.push({ny, nx});
                        newdone[ny][nx]=1;

                        score[ny][nx]=(score[y][x]+1);
                    }
                }
                answer=max(answer,score[y][x]); // 큐에 마지막으로 남은 x,y => 그 bfs에서 가장 멀리 떨어진 bfs 좌표, 기록한 거리르 비교
            }
        }
    }
    cout<<answer;
}
```
```
