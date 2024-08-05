#include <iostream>
#include <queue>
#include <vector>
#include <cstdlib>
#include <cstring>

using namespace std;

int main(void) {
	int T;
	cin >> T;

	for (int tc = 1; tc <= T; tc++) {
		int n;
		cin >> n;

		int y, x;
		vector<pair<int, int>> house;
		cin >> y >> x;
		house.push_back({ y, x });

		vector<pair<int, int>> convenienceStore;
		for (int i = 0; i < n; i++) {
			cin >> y >> x;
			convenienceStore.push_back({ y, x });
		}

		vector<pair<int, int>> festival;
		cin >> y >> x;
		festival.push_back({ y, x });
		
		queue<pair<int, int>> q;
		q.push({ house.front().first, house.front().second });

		bool visited[100];
		memset(visited, false, sizeof(visited));

		bool result = false;
		while (!q.empty()) {
			int y = q.front().first;
			int x = q.front().second;
			q.pop();

			if (abs(festival.front().first - y) + abs(festival.front().second - x) <= 1000) {
				result = true;
				cout << "happy\n";
				break;
			}

			for (int i = 0; i < n; i++) {
				if (visited[i] == true) {
					continue;
				}

				if (abs(convenienceStore[i].first - y) + abs(convenienceStore[i].second - x) <= 1000) {
					visited[i] = true;
					q.push({ convenienceStore[i].first, convenienceStore[i].second });
				}
			}
		}

		if (!result) {
			cout << "sad\n";
		}
	}
	return 0;
}
