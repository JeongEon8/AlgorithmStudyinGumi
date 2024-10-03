# [SWEA - D5] 1248. 공통조상
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
트리
그래프 탐색
너비 우선 탐색


## :round_pushpin: **Logic**
1. 먼저 두 노드의 조상을 모두 구해 공통 조상을 찾는다
2. 공통 조상으로부터 아래로 bfs를 이용해 서브트리의 크기를 구해준다.
```#include <iostream>
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
```
