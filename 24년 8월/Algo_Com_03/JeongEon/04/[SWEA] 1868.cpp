#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

using namespace std;

int n;
string s;
char game[301][301];
int visited[301][301] = { 0, };
int dx[8] = { 0, 0, -1, 1, -1, 1, -1, 1 };
int dy[8] = { -1, 1, 0, 0, -1, 1, 1, -1 };
int num = 0;

// 주위 8칸에 모두 지뢰가 없는지 확인
bool check(int x, int y) {
    for (int i = 0; i < 8; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
            if (game[nx][ny] == '*') {
                return false;
            }
        }
    }
    return true;
}

void play() {
    // 주위 8칸에 지뢰가 없는 빈칸을 찾는다.
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!visited[i][j] && game[i][j] == '.' && check(i, j)) {
                num++;
                // visited[i][j] = 1;
                queue<pair<int, int>> q;
                q.push(make_pair(i, j));

                while (!q.empty()) {
                    int x = q.front().first;
                    int y = q.front().second;
                    visited[x][y] = 1;
                    q.pop();

                    for (int k = 0; k < 8; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny] && game[nx][ny] == '.') {
                            visited[nx][ny] = 1;
                            if (check(nx, ny)) { // 주위에 8칸에 지뢰가 없는 곳
                                q.push(make_pair(nx, ny));
                            }
                        }
                    }
                }
            }
        }
    }
}

int main() {
    int T;
    cin >> T;

    for (int tc = 1; tc <= T; tc++) {
        num = 0;
        memset(visited, 0, sizeof(visited));
        cin >> n;
        for (int i = 0; i < n; i++) {
            cin >> s;
            for (int j = 0; j < s.size(); j++) {
                game[i][j] = s[j];
            }
        }

        play();
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (!visited[j][k] && game[j][k] == '.') {
                    num++;
                }
            }
        }
        cout << "#" << tc << " ";
        cout << num << "\n";
    }
}
