#include <iostream>

using namespace std;

#define MAX 501

int n, m;
int map[MAX][MAX];
bool visited[MAX];
bool friends[MAX];
int ans = 0;

void function() {
    //상근이의 친구 
    for (int i = 2; i <= n; i++) {
        if (map[1][i] == 1) {
            visited[i] = true;
            friends[i] = true;
        }
    }
    //상근이의 친구의 친구
    for (int i = 2; i <= n; i++) {
        if (friends[i]) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j]) {
                    visited[j] = true;
                }
            }
        }
    }

    for (int i = 2; i <= n; i++) {
        if (visited[i]) {
            ans++;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    cin >> m;

    while (m--) {
        int a, b;
        cin >> a >> b;
        map[a][b] = 1;
        map[b][a] = 1;
    }

    function();
    cout << ans;

    return 0;
}
