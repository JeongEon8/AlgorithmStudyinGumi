// �˰����� �ڵ� ���͵� 14ȸ��
// SWEA D3
// 1860. ������ �ְ��� �ؾ

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	for (int t = 1; t <= T; t++) {
		int N, M, K;
		cin >> N >> M >> K;

		vector<int> man;
		for (int i = 0; i < N; i++) {
			int input;
			cin >> input;
			man.push_back(input);
		}

		sort(man.begin(), man.end());

		int time = 0;
		int fishbread = 0;
		bool result = true;
		for (int i = 0; i < N; i++) {
			if (man[i] == time) {
				if (fishbread <= 0) {
					result = false;
					break;
				}
				fishbread--;
			}
			else if (man[i] > time && man[i] < time + M) {
				if (fishbread <= 0) {
					result = false;
					break;
				}
				fishbread--;
			}
			else {
				i--;
				time += M;
				fishbread += K;
			}
		}


		cout << "#" << t << " ";
		if (result) {
			cout << "Possible" << '\n';
		}
		else {
			cout << "Impossible" << '\n';
		}
	}

	return 0;
}
