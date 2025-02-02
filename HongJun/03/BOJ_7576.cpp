#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define MAX 1001

void FASTIO() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
}

int m, n;
int visited[MAX][MAX];
int tomato[MAX][MAX];
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
queue<pair<int, int>> q;

void bfs() {
    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (tomato[nx][ny] == 0) {
                    tomato[nx][ny] = tomato[x][y] + 1;
                    q.push({nx, ny});
                }
            }
        }
    }
}

int main() {
    FASTIO();

    cin >> m >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> tomato[i][j];

            if (tomato[i][j] == 1) {
                q.push({i, j});
            }
        }
    }

    bfs();

    int answer = -1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {

            if (tomato[i][j] == 0) {
                cout << -1;
                return 0;
            } else {
                answer = max(tomato[i][j], answer);
            }
        }
    }

    cout << answer -1 << '\n';
    return 0;
}