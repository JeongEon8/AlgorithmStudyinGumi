#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
    int N;
    cin >> N;
    vector<int> li(N);

    for (int i = 0; i < N; i++) {
        cin >> li[i];
    }

    sort(li.begin(), li.end());

    int st = 0, en = N - 1;
    int ans1 = 0, ans2 = 0;

    // 산성 용액만 또는 알칼리성 용액만 있을 때
    if (li[st] > 0 || li[en] < 0) {
        ans1 = li[st];
        ans2 = li[en];
    }

    // 혼합 특성값의 최소값 구하기 -> 초기값 = 최대치
    int MIN = 2 * 1e9;

    while (st < en) {
        int tmp = li[st] + li[en];

        if (tmp < 0) {
            tmp = abs(tmp);
            if (tmp < MIN) {
                MIN = tmp;
                ans1 = li[st];
                ans2 = li[en];
            }
            st++;
        } else if (tmp > 0) {
            if (tmp < MIN) {
                MIN = tmp;
                ans1 = li[st];
                ans2 = li[en];
            }
            en--;
        } else {
            ans1 = li[st];
            ans2 = li[en];
            break;
        }
    }

    cout << ans1 << " " << ans2 << endl;

    return 0;
}