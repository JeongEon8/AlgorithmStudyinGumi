#include <iostream>

using namespace std;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

    unsigned long long T;
    cin >> T;

    while (T--) {
        unsigned long long N;
        cin >> N;

        unsigned long long left = 1;
        unsigned long long right = N;
        unsigned long long mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (mid * (mid + 1) / 2 <= N) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        cout << right << '\n';
    }
}
