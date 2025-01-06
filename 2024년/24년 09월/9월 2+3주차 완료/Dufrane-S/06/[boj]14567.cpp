#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int before[1001];
vector<int> daum[1001];
int answer[1001];

int main() {
    int n, m;
    cin >> n >> m;
    int a, b;
    for (int i = 0; i < m; i++) {
        cin >> a >> b;
        before[b]++;
        daum[a].push_back(b);
    }
    queue<pair<int, int>> q;
    for (int i = 1; i <= n; i++) {
        if (before[i] == 0) {
            q.push({i, 0});
        }
    }
    while (!q.empty()) {
        int now = q.front().first;
        int depth = q.front().second;
        answer[now] = depth;
        q.pop();
        for (auto i: daum[now]) {
            before[i]--;
            if (before[i] == 0) {
                q.push({i, depth + 1});
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        cout << answer[i] + 1 << ' ';
    }
}
