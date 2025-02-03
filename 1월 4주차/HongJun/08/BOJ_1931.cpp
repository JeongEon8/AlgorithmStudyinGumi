#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(pair<int, int> a, pair<int, int> b) {
    if (a.second == b.second) {
        return a.first < b.first;  // 시작 시간 기준 오름차순 정렬
    }
    return a.second < b.second;  // 종료 시간 기준 오름차순 정렬
}

int main() {
    int n;
    cin >> n;

    vector<pair<int, int>> time(n);
    for (int i = 0; i < n; i++) {
        cin >> time[i].first >> time[i].second;
    }

    // 시작 시간 기준으로 오름차순 하고 나서 끝나는 시간 기준으로 오름차순
    sort(time.begin(), time.end(), compare);

    int last = 0, count = 0;

    for (auto &t : time) {
        // 시작 시간이 현재 끝나는 시간 보다 뒤에 있으면 갱신
        if (t.first >= last) {
            count++;
            last = t.second;
        }
    }

    cout << count << endl;

    return 0;
}