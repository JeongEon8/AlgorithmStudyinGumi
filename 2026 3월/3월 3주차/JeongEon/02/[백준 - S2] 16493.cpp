#include <iostream>
using namespace std;

int D, N;
int A[20], P[20];
int days, val, ans;

void func(int idx) {
    if (idx == N) {
        if (days <= D) ans = max(ans, val);
        return;
    }
    func(idx + 1);
    days += A[idx];
    val += P[idx];
    func(idx + 1);
    days -= A[idx];
    val -= P[idx];
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> D >> N;
    for (int i = 0; i < N; i++) cin >> A[i] >> P[i];
    func(0);

    cout << ans;
}
