#include <iostream>
#include <queue>

using namespace std;


int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};

int main() {

    int n, m;
    char box[600][600];
    cin >> n >> m;
    char a;
    int sx, sy;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a;
            box[i][j] = a;
            if (a == 'I') {
                sy = i;
                sx = j;
            }
        }
    }
    queue<pair<int, int>> q;
    q.push({sy, sx});
    box[sy][sx] = 'X';
    int answer = 0;
    while (!q.empty()) {
        int nowy = q.front().first;
        int nowx = q.front().second;
        q.pop();
        for (int k = 0; k < 4; k++) {
            int ny = nowy + dy[k];
            int nx = nowx + dx[k];
            if (ny < 0 || nx < 0 || ny == n || nx == m || box[ny][nx] == 'X')continue;
            if (box[ny][nx] == 'P')answer++;
            q.push({ny, nx});
            box[ny][nx] = 'X';
        }
    }
    if (answer) {
        cout << answer;
    } else {
        cout << "TT";
    }
}
