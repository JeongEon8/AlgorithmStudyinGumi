#include <iostream>
using namespace std;

int arr[300000] = { 0, };

int main()
{

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, m, maxJ = 0;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        cin >> arr[i];
    }

    int left = 1, right = 1e9, ans = 1e9;
    while (left <= right) {
        int mid = (left + right) / 2;
        long long cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += arr[i] / mid;
            if (arr[i] % mid != 0) {
                cnt++;
            }
        }
        if (cnt > n) {
            left = mid + 1;
        }
        else {
            if (mid < ans) {
                ans = mid;
            }
            right = mid - 1;
        }
    }
    cout << ans;


}