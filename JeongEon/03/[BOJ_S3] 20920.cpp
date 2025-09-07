#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<pair<int, int>, string> a, pair<pair<int, int>, string> b) {
	if (a.first.first == b.first.first) {
		if (a.first.second == b.first.second) {
			return a.second < b.second;
		}

		return a.first.second > b.first.second;
	}

	return a.first.first > b.first.first;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	cin >> N >> M;
	
	map<string, int> map;
	vector<pair<pair<int, int>, string>> arr;

	int n = 0;

	for (int i = 0; i < N; i++) {
		string input;
		cin >> input;
		
		if (input.length() >= M) {
			if (map.find(input) != map.end()) {
				arr[map.find(input)->second].first.first++;
			}
			else {
				map.insert({ input, n });
				arr.push_back({ {1, input.length()}, input});
				n++;
			}
		}
	}
	
	sort(arr.begin(), arr.end(), compare);

	for (int i = 0; i < arr.size(); i++) {
		cout << arr[i].second << '\n';
	}

	return 0;
}
