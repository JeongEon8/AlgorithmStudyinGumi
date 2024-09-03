# [SWEA - D4] 7465. 창용 마을 무리의 개수
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## :round_pushpin: **Logic**
1. 입력을 받아 관계를 나타내는 배열을 만들어 bfs해서 무리를 구해준다.
```#include <iostream>
#include <vector>
#include <queue>
using namespace std;
 
int main() {
    int ct;
    cin >> ct;
    for (int ctnow = 1; ctnow <= ct; ctnow++) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>>box = vector<vector<int>>(n);
        vector<bool>done(n, false);
        for (int i = 0; i < m; i++) {
            int a, b;
            cin >> a >> b;
            a--; b--;
            box[a].push_back(b);
            box[b].push_back(a);
        }
        int answer = 0;
 
     
         
        for (int i = 0; i < n; i++) {
            if (done[i] == false) {
                answer++;
                done[i] = true;
                queue<int>q;
                q.push(i);
                while (!q.empty())
                {
                    int now = q.front();
                    q.pop();
                    for (auto k : box[now]) {
                        if (done[k] == false) {
                            q.push(k);
                            done[k] = true;
                        }
                    }
                }
            }
        }
 
        cout << '#' << ctnow << ' ' << answer << '\n';
    }
}
```
