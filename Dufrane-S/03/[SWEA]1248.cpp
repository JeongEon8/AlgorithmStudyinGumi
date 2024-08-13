#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main() {

	int tc_n;
	cin >> tc_n;
	for (int tc = 1; tc <= tc_n; tc++) {
		int v, e, n, m;
		cin >> v >> e >> n >> m;

		vector<vector<int>>pgraph(v+1, vector<int>(0));
		vector<vector<int>>cgraph(v+1, vector<int>(0));
		for (int i = 0; i < e; i++) {
			int a, b;
			cin >> a >> b;
			pgraph[b].push_back(a);
			cgraph[a].push_back(b);
		}

		vector<int>nps;
		vector<int>mps;
		int temp = n;

		while (true) {
			if (!pgraph[temp].empty()) {
				nps.push_back(pgraph[temp][0]);
				temp = pgraph[temp][0];
			}
			else
			{
				break;
			}
		}

		temp = m;
		while (true) {
			if (!pgraph[temp].empty()) {
				mps.push_back(pgraph[temp][0]);
				temp = pgraph[temp][0];
			}
			else
			{
				break;
			}
		}
		int same = -1;

		for (auto i : nps) {
			for (auto j : mps) {
				if (i == j) {
					same = i;
					break;
				}
			}
			if (same != -1)break;
		}


		queue<int>q;
		q.push(same);
		int sizenum = 0;
		while (!q.empty()) {
			int now = q.front();
			sizenum++;
			q.pop();
			for (auto i : cgraph[now]) {
				q.push(i);
			}
		}


		cout << '#' << tc << ' ' << same << ' ' << sizenum<<'\n';
	}

}
