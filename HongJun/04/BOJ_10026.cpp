#include <iostream>
#include <cstring>
using namespace std;

char arr[100][100];
int visited[100][100] = {0, };
int n;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};

void dfs(int x, int y) {
    visited[x][y] = 1;

    for(int i = 0 ; i < 4 ; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || arr[nx][ny] != arr[x][y]) continue;
        dfs(nx, ny);
    }
}

int main() {
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    int cnt = 0, cnt_rg = 0;
    cin >> n;

    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < n ; j++) {
            cin >> arr[i][j];
        }
    }

    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < n ; j++) {
            if(!visited[i][j]){
                dfs(i, j);
                cnt++;
            }
        }
    }

    memset(visited, 0, sizeof(visited));

    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < n ; j++) {
            if(arr[i][j] == 'R') arr[i][j] = 'G';
        }
    }

    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < n ; j++) {
            if (!visited[i][j]) {
                dfs(i, j);
                cnt_rg++;
            }
        }
    }

    cout << cnt << " " << cnt_rg << '\n';

    return 0;
}