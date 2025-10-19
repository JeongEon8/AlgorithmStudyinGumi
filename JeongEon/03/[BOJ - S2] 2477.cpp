#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b)
{
    if (a.first == b.first)
        return a.second < b.second;
    return a.first < b.first;
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int K, temp1, temp2, total = 1, small = 1;
    vector<int> count(4, 0);
    vector<int> v;
    vector<pair<int, int>> vp;
    
    cin >> K;
    
    for (int i = 0; i < 6; i++) {
        cin >> temp1 >> temp2;
        vp.push_back(pair<int, int>(temp1, temp2));
        count[temp1 - 1]++;
    }
    
    for (int i = 0; i < 6; i++) {
        if (count[vp[i].first - 1] == 1) {
            total *= vp[i].second;
            continue;
        }
        int next = (i + 1) % 6;
        int nextnext = (i + 2) % 6;
        if (vp[i].first == vp[nextnext].first) {
            small *= vp[next].second;
        }
    }

    cout << (total - small) * K;

    return 0;
}
