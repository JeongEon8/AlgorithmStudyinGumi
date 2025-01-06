#include <iostream>
#include <algorithm>
#include <queue>
#include <map>

using namespace std;

priority_queue<int, vector<int>, greater<int>> min_pq; // 최소 힙
priority_queue<int, vector<int>, less<int>> max_pq; // 최대 힙
map<int, int> cnt; // cnt[i] : 숫자 i의 개수

void insert(int n) {
    min_pq.push(n);
    max_pq.push(n);
    cnt[n]++;
}

void deleteMin() {
    if (!min_pq.empty()) {
        cnt[min_pq.top()]--;
        min_pq.pop();
    }
}

void deleteMax() {
    if (!max_pq.empty()) {
        cnt[max_pq.top()]--;
        max_pq.pop();
    }
}

// 힙에서 삭제된 값이 top과 다르면 pop하고 진행
void cleanPq() {
    while (!min_pq.empty() && cnt[min_pq.top()] == 0) {
        min_pq.pop();
    }
    while (!max_pq.empty() && cnt[max_pq.top()] == 0) {
        max_pq.pop();
    }
}

int main() {
    int T, n, k;
    char cmd;

    cin >> T;

    while (T--) {
        while (!min_pq.empty()) {
            min_pq.pop();
        }
        while (!max_pq.empty()) {
            max_pq.pop();
        }
        cnt.clear();

        cin >> k;
        for (int i = 0; i < k; i++) {
            cin >> cmd >> n;

            if (cmd == 'I') {
                insert(n);
            }
            else {
                if (n == 1) {
                    deleteMax();
                }
                else {
                    deleteMin();
                }
                cleanPq();
            }
        }

        cleanPq();
        if (min_pq.empty()) {
            cout << "EMPTY\n";
        }
        else {
            cout << max_pq.top() << " " << min_pq.top() << "\n";
        }
    }

    return 0;
}
