#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N; // 사람 수
	int M; // 파티 수
	cin >> N >> M;

	map<int, bool> people;
	map<int, bool> party;
	vector<vector<int>> member(M); 

	for (int i = 1; i <= N; i++) {
		people.insert({ i, false });
	}

	int truthNum;
	cin >> truthNum;
	for (int i = 0; i < truthNum; i++) {
		int input;
		cin >> input;
		people[input] = true;
	}

	for (int i = 0; i < M; i++) {
		int num;
		cin >> num;
		for (int j = 0; j < num; j++) {
			int input;
			cin >> input;
			member[i].push_back(input);
		}
	}

	for (int i = 0; i < M; i++) {
		bool flag = false;
		for (int j = 0; j < member[i].size(); j++) {
			if (people[member[i][j]]) {
				flag = true;
				party[i] = true;
				break;
			}
		}

		if (!flag) {
			continue;
		}

		for (int j = 0; j < member[i].size(); j++) {
			if (people[member[i][j]] == false) {
				people[member[i][j]] = true;
				i = -1;
			}
		}
	}


	int cnt = 0;
	for (int i = 0; i < M; i++) {
		if (!party[i])
			cnt++;
	}

	cout << cnt << "\n";


	return 0;
}
