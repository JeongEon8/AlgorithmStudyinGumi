#include <iostream>
#include <queue>

using namespace std;
#define MAX 301

int T, I;
int nowX, nowY, targetX, targetY;
int arr[MAX][MAX];
int visited[MAX][MAX];
int dx[] = { 1,2,2,1,-1,-2,-2,-1 };
int dy[] = { 2,1,-1,-2,-2,-1,1,2 };
queue<pair<int, int>> q;

void reset() {
    while (!q.empty()) {
        q.pop();
    }

    for (int i = 0; i < MAX; i++) {
        for (int j = 0; j < MAX; j++) {
            visited[i][j] = 0;
            arr[i][j] = 0;
        }
    }
}

void bfs(int x, int y) {
    q.push({ x,y });
    visited[x][y] = 1;

    while (!q.empty()) {
        int a = q.front().first;
        int b = q.front().second;
        q.pop();

        if (a == targetX && b == targetY) {
            cout << arr[a][b] << "\n";
            return;
        }

        for (int i = 0; i < 8; i++) {
            int na = a + dx[i];
            int nb = b + dy[i];

            if (0 <= na && 0 <= nb && na < I && nb < I && !visited[na][nb]) {
                q.push({ na,nb });
                visited[na][nb] = 1;
                arr[na][nb] = arr[a][b] + 1;
            }
        }
    }
}

int main() {
    cin >> T;
    for (int i = 0; i < T; i++) {
        cin >> I;
        cin >> nowX >> nowY;
        cin >> targetX >> targetY;

        reset();
        bfs(nowX, nowY);
    }
}
