#include <iostream>
#include <cstring>

using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	int people[50][2];
	int cnt[50];
	memset(cnt, 0, sizeof(cnt));
	for (int i = 0; i < N; i++) {
		cin >> people[i][0] >> people[i][1];
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (i == j) {
				continue;
			}

			if (people[i][0] < people[j][0]) {
				if (people[i][1] < people[j][1]) {
					cnt[i]++;
				}
			}
		}
		cout << cnt[i] + 1 << " ";
	}
	return 0;
}
