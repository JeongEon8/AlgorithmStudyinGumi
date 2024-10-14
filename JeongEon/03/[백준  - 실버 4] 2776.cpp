#include <iostream>
#include <set>

using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	for (int tc = 1; tc <= T; tc++) {
		int N;
		cin >> N;

		set<int> memo1;
		for (int i = 0; i < N; i++) {
			int input;
			cin >> input;
			memo1.insert(input);
		}

		int M;
		cin >> M;
		for (int i = 0; i < M; i++) {
			int input;
			cin >> input;

			if (memo1.find(input) != memo1.end()) {
				cout << 1 << "\n";
			}
			else {
				cout << 0 << "\n";
			}
		}


	}

	return 0;
}
