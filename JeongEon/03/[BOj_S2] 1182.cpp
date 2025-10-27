#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int N, sum;
vector<int> arr;

int cnt = 0;

void solve(int idx, int tmp) {
	if (idx == N) {
        return;
    }
	if (tmp + arr[idx] == sum) {
        cnt++;
    }

	solve(idx + 1, tmp);
	solve(idx + 1, tmp + arr[idx]);
}

int main(void) {
	cin >> N >> sum;

	for (int i = 0; i < N; i++) {
		int tmp;
		cin >> tmp;
		arr.push_back(tmp);
	}

	solve(0, 0);
	cout << cnt;

	return 0;
}
