#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(void) {
    int L; cin >> L;
    vector<int> v(L);

    for (int i = 0; i < L; i++) {
        cin >> v[i];
    }
    v.push_back(0);

    int n; cin >> n;
    int s, e;
    bool b = true;

    sort(v.begin(), v.end());
    for (int i = 1; i < L + 1; i++) {
        if (n == v[i]) {
          b = false;  
        }
        else if (n < v[i]) {
            s = v[i - 1] + 1;
            e = v[i] - 1;
            break;
        }
    }

    if (b) {
        cout << (n - s) * (e - n + 1) + (e - n);
    }
    else {
        cout << 0;
    }

    return 0;
}
