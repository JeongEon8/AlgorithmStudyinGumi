#include <iostream>

using namespace std;

typedef long long ll;
typedef pair<int, int> pii;
const int MAX = 2147483647;

int N, M;
int dp[10001];
const int MOD = 1000000007;

int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> N >> M;
    dp[0] = 1;

    for (int i = 1; i <= N; i++) {
        dp[i] = dp[i - 1];
        if (i >= M) {
            dp[i] = (dp[i] + dp[i - M]) % MOD;
        }
    }

    cout << dp[N];

    return 0;
}
