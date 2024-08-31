# [백준 - G5] 6593. 상범 빌딩
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS


## :round_pushpin: **Logic**
1. 3차원 bfs, 상하 이동 z 값 추가하여 bfs
```#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int dx[6] = {0, 0, 1, -1, 0, 0};
int dy[6] = {1, -1, 0, 0, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};

int main() {
    while (true) {
        int a, b, c;

        cin >> a >> b >> c;
        if (a == 0 && b == 0 && c == 0)break;
        int sz, sy, sx, ez, ey, ex;
        vector<vector<vector<int>>> box = vector<vector<vector<int>>>(a,
                                                                      vector<vector<int>>(b, vector<int>(c, 0)));
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                for (int k = 0; k < c; k++) {
                    char qwer;
                    cin >> qwer;
                    if (qwer == 'S') {
                        sz = i;
                        sy = j;
                        sx = k;
                        box[i][j][k] = 0;
                    } else if (qwer == 'E') {
                        ez = i;
                        ey = j;
                        ex = k;
                        box[i][j][k] = -1;
                    } else if (qwer == '#') {
                        box[i][j][k] = -2;
                    } else {
                        box[i][j][k] = 0;
                    }
                }
            }
        }


        queue<vector<int>> q;
        vector<int> tmp;
        box[sz][sy][sx] = 1;
        tmp.push_back(sz);
        tmp.push_back(sy);
        tmp.push_back(sx);
        q.push(tmp);

        while (!q.empty()) {
            int nowz = q.front()[0];
            int nowy = q.front()[1];
            int nowx = q.front()[2];
            q.pop();
            for (int idx = 0; idx < 6; idx++) {
                int nz = nowz + dz[idx];
                int ny = nowy + dy[idx];
                int nx = nowx + dx[idx];
                if (nz < 0 || ny < 0 || nx < 0 || nz == a || ny == b || nx == c || box[nz][ny][nx] == -2)continue;
                if (box[nz][ny][nx] == -1) {
                    box[nz][ny][nx] = box[nowz][nowy][nowx];
                    break;
                } else if (box[nz][ny][nx] == 0) {
                    box[nz][ny][nx] = box[nowz][nowy][nowx] + 1;
                    tmp.clear();
                    tmp.push_back(nz);
                    tmp.push_back(ny);
                    tmp.push_back(nx);
                    q.push(tmp);
                } else {
                    continue;
                }

            }
        }

        if (box[ez][ey][ex] == -1) {
            cout << "Trapped!\n";
        } else {
            cout << "Escaped in " << box[ez][ey][ex] << " minute(s).\n";
        }
    }
}


```
