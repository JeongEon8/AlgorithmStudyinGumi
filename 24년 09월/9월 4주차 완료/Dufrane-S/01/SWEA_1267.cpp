#include <iostream>
#include <vector>
#include <queue>
 
using namespace std;
 
int main() {
 
    int ctn = 10;
    for (int ct = 1; ct <= ctn; ct++) {
        int n, m;
        cin >> n >> m;
        int a, b;
        int before[n + 1];
        for (int i = 0; i <= n; i++) {
            before[i] = 0;
        }
        vector<int> next[n + 1];
        for (int i = 0; i < m; i++) {
            cin >> a >> b;
            next[a].push_back(b);
            before[b]++;
        }
 
        cout << '#' << ct << ' ';
        queue<int> q;
        for (int i = 1; i <= n; i++) {
            if (before[i] == 0) {
                q.push(i);
                cout << i << ' ';
            }
        }
        while (!q.empty()) {
            int now = q.front();
            q.pop();
            for (auto i: next[now]) {
                before[i] -= 1;
                if (before[i] == 0) {
                    q.push(i);
                    cout << i << ' ';
                }
            }
        }
 
    }
 
}
