#include<iostream>
#include<vector>
#include <algorithm>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 입력부
    int tc = 0;
    cin >> tc;

    for (int i = 0; i < tc; i++) {
        int N;
        cin >> N;
        vector<int> v;
        for (int j = 0; j < N; j++) {
            int tmp;
            cin >> tmp;
            v.push_back(tmp);
        }

        int maxx = -1;
        long result = 0;
        for (int k = N - 1; k >= 0; k--) {
            maxx = max(maxx, v[k]);
            result += maxx - v[k];
        }

        cout << result << '\n';
    }

    return 0;
}
