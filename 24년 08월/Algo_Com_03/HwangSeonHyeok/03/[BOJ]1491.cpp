#include <iostream>
using namespace std;

int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

int arr[5001][5001] = { 0, };
bool visited[5001][5001] = { 0, };



int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, m;
    cin >> n >> m;

    int total = n * m - 1;
    int cnt = 0;
    int dir = 0;
    int x = 0, y = 0;
    while (cnt++ != total) {
        visited[y][x] = true;
        if (x + dx[dir % 4] < 0 || y + dy[dir % 4] < 0 || x + dx[dir % 4] == n || y + dy[dir % 4] == m || visited[y + dy[dir % 4]][x + dx[dir % 4]]) {
            dir++;
        }
        x += dx[dir % 4];
        y += dy[dir % 4];
    }
    cout << x << ' ' << y;

}