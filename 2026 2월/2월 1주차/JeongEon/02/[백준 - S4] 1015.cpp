#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    vector<pair<int, int>> a(n);
    vector<int> b(n);

    for(int i = 0; i < n; i++){
        cin >> a[i].first;
        a[i].second = i;
    }

    sort(a.begin(), a.end());

    for(int i = 0; i < n; i++){
        b[a[i].second] = i;
    }

    for(int i = 0; i < n; i++){
        cout << b[i] << " ";
    }

    return 0;
}
