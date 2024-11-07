#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int, int> a, pair<int, int> b) {
	if (a.second == b.second) {
		return a.first < b.first;
	}

	return a.second > b.second;
}


int arr[201][201][201];

int main(void) {
	int N, M;
	cin >> N >> M;

	vector<int> score;
	for (int i = 0; i < N; i++) {
		int input;
		cin >> input;
		score.push_back(input);
	}

	vector<pair<int, int>> student;
	for (int i = 0; i < M; i++) {
		int num;
		cin >> num;
		
		int result = 0;
		for (int j = 0; j < N; j++) {
			char input;
			cin >> input;
			if (input == 'O') {
				result += score[j];
			}
		}
		student.push_back({ num, result });
	}

	sort(student.begin(), student.end(), compare);

	cout << student[0].first << " " << student[0].second << '\n';

	return 0;
}
