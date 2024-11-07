#include <iostream>
#include <queue>

using namespace std;

int main() {
    int N;
    cin >> N;
    for (int I = 0; I < N; I++) {
        int n, m;
        cin >> n >> m;
        queue<pair<int, int>> q;
        priority_queue<int> pq;
        for (int i = 0; i < n; i++) {
            int a;
            cin >> a;
            pq.push(a);
            q.push({a, i});
        }
        int answer = 1;
        while (true) {
            if (q.front().second == m && pq.top() == q.front().first)break;
            if(q.front().first==pq.top()){
                q.pop();
                pq.pop();
                answer++;
            }else {
                q.push(q.front());
                q.pop();
            }
        }
        cout << answer << '\n';
    }

}
