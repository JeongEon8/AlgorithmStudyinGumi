#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <climits>
using namespace std;

int main() {
	int n, m;
	cin >> n >> m;
	vector<vector<int>>box = vector<vector<int>>(101, vector<int>(0));
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		a--;
		b--;
		box[a].push_back(b);
		box[b].push_back(a);
	}
	int small = INT_MAX;
	int answer = -1;
	for (int i = 0; i < n; i++) {
		int sum = 0;
		for (int j = 0; j < n; j++) {
			vector<bool>done(101, false);
			if (i == j)continue;
			queue<pair<int,int>>q;
			q.push({ j,0 });
			done[j] = true;
			while (!q.empty()) {
				int now = q.front().first;
				int depth = q.front().second;
				if (now == i) {
					sum += depth;
					break;
				}
				q.pop();
				for (auto k : box[now]) {
					if (done[k] == false) {
						q.push({ k,depth + 1 });
						done[k] = true;
					}
				}
			}
		}
		if (sum < small) {
			small = sum;
			answer = i;
		}
	}
	cout << ++answer;
}
