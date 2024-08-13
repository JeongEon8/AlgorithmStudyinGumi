#include <iostream>
using namespace std;

long long arr[1000001] = { 0, };

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    long long n, m, ans = 0L;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        ans += arr[i];
    }

    long long left = 1, right = 1e9, mid = (left + right) / 2;;
    while (left <= right) {
        long long sum = 0L;
        long long cnt = 0L;
        for (int i = 0; i < n; i++) {
            cnt += arr[i] / mid;
        }
        if (cnt >= m) {

            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
        mid = (left + right) / 2;
    }
    ans = ans - mid * m;
    cout << ans;


}