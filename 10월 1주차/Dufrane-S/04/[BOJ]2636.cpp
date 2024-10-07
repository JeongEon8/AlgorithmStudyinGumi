#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int n, m;
int box[101][101];

bool checkOut(int y, int x) {

    for (int k = 0; k < 4; k++) {
        int ny = y + dy[k];
        int nx = x + dx[k];
        if (ny < 0 || nx < 0 || ny == n || nx == m)return true;
        if (box[ny][nx] == -1)return true;
    }
    return false;
}

//-1밖이랑 연결 -2 내부 치즈 구멍
void check(int y, int x) {
    bool flag = false;
    queue<pair<int, int>> q;
    queue<pair<int, int>> group;
    group.push({y, x});
    q.push({y, x});
    box[y][x] = -2;
    while (!q.empty()) {
        int nowy = q.front().first;
        int nowx = q.front().second;
        q.pop();
        for (int k = 0; k < 4; k++) {
            int ny = nowy + dy[k];
            int nx = nowx + dx[k];
            if (ny < 0 || nx < 0 || ny == n || nx == m) {
                flag = true;
                continue;
            }
            if (box[ny][nx] != 0)continue;
            box[ny][nx] = -2;
            q.push({ny, nx});
            group.push({ny, nx});
        }
    }
    if (flag) {
        while (!group.empty()) {
            int ny = group.front().first;
            int nx = group.front().second;
            group.pop();
            box[ny][nx] = -1;
        }
    }

}

int main() {
    cin >> n >> m;
    int a;
    int count =0;
    vector<pair<int, int>> cheese;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a;
            box[i][j] = a;
            if (a == 1)cheese.push_back({i, j});
        }
    }
    while (true) {


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    check(i, j);
                }
            }
        }


        vector<pair<int, int>> new_cheese;
        for (auto i: cheese) {
            if (!checkOut(i.first, i.second)) {
                new_cheese.push_back(i);
            }
        }
        if (!new_cheese.empty()) {
            cheese = new_cheese;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    box[i][j] = 0;
                }
            }
            for (auto i: cheese) {
                box[i.first][i.second] = 1;
            }


        } else {
            count++;
            cout << count<<'\n'<<cheese.size();
            break;
        }
        count++;
    }
}
