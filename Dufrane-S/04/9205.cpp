#include <iostream>
#include <vector>
#include <queue>

using namespace std;


int main() {
    int N;
    cin >> N;
    for (int I = 0; I < N; I++) {
        string answer = "sad";
        int n;
        cin >> n;
        vector<pair<int, int>> v(n + 2);
        vector<vector<int>> check(n + 2);
        int a, b;
        cin >> a >> b;
        v[0] = {a, b};
        for (int i = 1; i <= n; i++) {
            cin >> a >> b;
            v[i] = {a, b};
        }
        cin >> a >> b;
        v[n + 1] = {a, b};
        for (int i = 0; i < n + 2; i++) {
            for (int j = i + 1; j < n + 2; j++) {
                if ((abs(v[i].first - v[j].first) + abs(v[i].second - v[j].second)) <= 1000) {
                    check[i].push_back(j);
                    check[j].push_back(i);
                }
            }
        }

        queue<int> q;
        q.push(0);
        vector<bool> done(n + 2, false);
        done[0] = true;
        while (!q.empty() && answer == "sad") {
            int now = q.front();
            q.pop();
            for (auto i: check[now]) {
                if (!done[i]) {
                    q.push(i);
                    done[i] = true;
                }
                if (i == n + 1)answer = "happy";
            }
        }
        cout << answer << '\n';
    }
}

