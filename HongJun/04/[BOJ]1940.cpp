#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
vector<int> v;

int main() {
    cin >> N >> M;

    for (int i = 0; i<N; i++) {
        int x;
        cin >> x;
        v.push_back(x);
    }

    int st = 0, en = N-1, ans = 0;
    sort(v.begin(), v.end());

    while (st < en) {
        if (v[st] + v[en] < M) {
            st += 1;
        }
        else if (v[st] + v[en] > M) {
            en -= 1;
        }
        else {
            ans += 1;
            st += 1;
            en -= 1;
        }
    }
    cout << ans;
}