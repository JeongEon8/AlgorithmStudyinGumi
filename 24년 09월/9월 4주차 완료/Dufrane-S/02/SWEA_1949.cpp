#include <iostream>
#include <queue>
 
using namespace std;
int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};
int box[8][8];
int copy_box[8][8];
bool done[8][8];
bool cut = false;
int n, m, tmp, answer;
 
 
void clean() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            done[i][j] = false;
            copy_box[i][j] = box[i][j];
        }
    }
}
 
 
void dfs(int y, int x) {
 
    if (answer < tmp) {
        answer = tmp;
    }
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || nx < 0 || ny == n || nx == n || done[ny][nx])continue;
        if (copy_box[ny][nx] < copy_box[y][x]) {
            done[ny][nx] = true;
            tmp++;
            dfs(ny, nx);
            tmp--;
            done[ny][nx] = false;
        } else if (!cut && copy_box[ny][nx] - m < copy_box[y][x]) {
            done[ny][nx] = true;
            tmp++;
            cut = true;
            int temp = copy_box[ny][nx];
            copy_box[ny][nx] = copy_box[y][x] - 1;
            dfs(ny, nx);
            copy_box[ny][nx] = temp;
            cut = false;
            tmp--;
            done[ny][nx] = false;
        }
    }
}
 
int main() {
    int ctn;
    cin >> ctn;
 
    for (int ct = 1; ct <= ctn; ct++) {
        answer = 0;
        cin >> n >> m;
        int a;
        int top = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> a;
                box[i][j] = a;
                top = top > a ? top : a;
            }
        }
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j] == top) {
                    clean();
                    tmp = 1;
                    cut = false;
                    done[i][j] = true;
                    dfs(i, j);
                }
            }
        }
 
        cout << '#' << ct << ' ' << answer << '\n';
    }
 
}
