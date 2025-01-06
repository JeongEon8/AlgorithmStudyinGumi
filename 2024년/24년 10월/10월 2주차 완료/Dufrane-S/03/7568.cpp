#include <iostream>
#include <vector>


using namespace std;

int main() {
    int n;
    cin >> n;
    vector<pair<int, int>> v;
    for (int i = 0; i < n; i++) {
        int a, b;
        cin >> a >> b;
        v.push_back({a, b});
    }
    for (auto i: v) {
        int tmp = 1;
        for (auto j: v) {
            if (i.first < j.first && i.second < j.second) {
                tmp++;
            }
        }
        cout << tmp << ' ';
    }

}
