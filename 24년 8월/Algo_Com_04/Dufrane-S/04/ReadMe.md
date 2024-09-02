# [백준 - G5] 9205. 맥주 마시면서 걸어가기
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
BFS, 그래프 탐색


## :round_pushpin: **Logic**
1. 먼저 맥주 20병 * 50m = 1000m를 이동 가능함을 의미
2. 이를 바탕으로 시작점과 편의점 그리고 도착점들이 서로 이어져있는지 판별 해준다.
3. 시작점과 연결된 점을 탐색하면서 도착점이 있는지 확인해서 결과를 도출한다.
```#include <iostream>
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
```
