#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
    int n, l;
    cin >> n >> l;
    vector<int> h;
    int a;
    for (int i = 0; i < n; i++) {
        cin >> a;
        h.push_back(a);
    }
    sort(h.begin(), h.end());
    int answer = 0;
    int idx = 0;
    while (idx < h.size()) {
        int now = h[idx];
        int end = now + l - 1;
        for (int i = idx; i < h.size(); i++) {
            if(end<h[i])break;
            idx++;
        }
        answer++;
    }
    cout<<answer;
}
