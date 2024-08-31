# [백준 - G5] 4179. 불!
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
BFS


## :round_pushpin: **Logic**
1. 먼저 사람의 탈출 경로를 bfs를 통해 구해준다. (탈출구가 여러 개 있으면 모두 저장)(불 경로로 구분을 위해 양수로 저장)
2. 불을 bfs해준다.(불의 시작점이 여러 곳일 수 있음)(사람 경로와 구분을 위해 음수로 저장)
3. 불 bfs시 다른 불이나 사람보다 늦었을 경우 굳이 탐색하지 않는다.
4. 탈출구의 좌표를 다시 확인해서 양수인 경우 중 작은 것을 출력하거나 IMPOSSIBLE 출력
```#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int main() {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> box = vector<vector<int>>(n, vector<int>(m, 0));

    queue<pair<int, int>> jq;
    queue<pair<int, int>> fq;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            char a;
            cin >> a;
            if (a == '#') {
                box[i][j] = -1;
            } else if (a == '.') {
                box[i][j] = 0;
            } else if (a == 'J') {
                jq.emplace(i, j);
                box[i][j] = 1;
            } else if (a == 'F') {
                fq.emplace(i, j);
                box[i][j] = -2;
            }
        }
    }


    vector<pair<int, int>> ep;
    while (!jq.empty()) {
        int nowjy = jq.front().first;
        int nowjx = jq.front().second;
        jq.pop();

        for (int k = 0; k < 4; k++) {
            if (box[nowjy][nowjx] == -2)break;
            int njy = nowjy + dy[k];
            int njx = nowjx + dx[k];
            if (njy < 0 || njx < 0 || njy == n || njx == m) {
                ep.emplace_back(nowjy, nowjx);
                continue;
            }
            if (box[njy][njx] != 0)continue;

            box[njy][njx] = box[nowjy][nowjx] + 1;
            jq.emplace(njy, njx);
        }
    }
    while (!fq.empty()) {
        int nowy = fq.front().first;
        int nowx = fq.front().second;
        fq.pop();
        for (int k = 0; k < 4; k++) {
            int ny = nowy + dy[k];
            int nx = nowx + dx[k];
            if (ny < 0 || nx < 0 || ny == n || nx == m)continue;
            if (box[ny][nx] < 0)continue;
            if (box[ny][nx] < abs(box[nowy][nowx] - 1) - 1)continue;
            box[ny][nx] = box[nowy][nowx] - 1;
            fq.emplace(ny, nx);
        }
    }
    int answer = INT_MAX;
    for (auto i: ep) {

        if (box[i.first][i.second] > 0 && answer > box[i.first][i.second])answer = box[i.first][i.second];
    }
    if (answer == INT_MAX) {
        cout << "IMPOSSIBLE";
    } else {
        cout << answer;
    }

}
```
