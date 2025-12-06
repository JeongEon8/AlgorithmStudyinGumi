#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N;
int n[9];
int result;
vector<int> v;
int visit[9];
int cnt = 0;

void solve() { //브루트포스 
	if (v.size() == N) {
		int tmp = 0;
		for (int i = 0; i < N-1; i++) {
			tmp += abs(v[i + 1] - v[i]);
		}
		result = max(result, tmp);
		return;
	}
	for (int i = 1; i <= N; i++) { //백트래킹
		if (!visit[i]) {
			visit[i] = 1;
			v.push_back(n[i]);
			solve();
			v.pop_back();
			visit[i] = 0;
		}
	}
}

int main() {
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> n[i];
	}

	solve();
	cout << result << endl;
}
