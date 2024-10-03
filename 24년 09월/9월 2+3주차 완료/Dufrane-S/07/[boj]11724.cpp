#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {

    int n, m;
    cin >> n >> m;
    vector<int> box[n];
    bool done[n];
    for (int i = 0; i < n; i++)done[i] = false;
    int a, b;
    for (int i = 0; i < m; i++) {
        cin >> a >> b;
        a--;
        b--;
        box[a].push_back(b);
        box[b].push_back(a);
    }
    int answer = 0;
    for (int i = 0; i < n; i++) {
        if (!done[i]) {
            done[i] = true;
            answer++;
            queue<int> q;
            q.push(i);
            while (!q.empty()) {
                int now = q.front();
                q.pop();
                for (auto k: box[now]) {
                    if (!done[k]) {
                        done[k] = true;
                        q.push(k);
                    }
                }
            }
        }
    }

    cout << answer;
}
