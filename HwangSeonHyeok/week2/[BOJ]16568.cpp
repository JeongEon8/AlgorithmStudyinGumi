#include <iostream>

using namespace std;

int dp[1000001] = { 0, };

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, a, b, ans;
    cin >> n >> a >> b;

    for (int i = 1; i <= n; i++) {
        int currentTime = dp[i - 1] + 1;
        if (i >= a + 1) {
            currentTime = dp[i - 1 - a] + 1 < currentTime ? dp[i - 1 - a] + 1 : currentTime;
        }
        if (i >= b + 1) {
            currentTime = dp[i - 1 - b] + 1 < currentTime ? dp[i - 1 - b] + 1 : currentTime;

        }
        dp[i] = currentTime;
    }


    cout << dp[n];


}