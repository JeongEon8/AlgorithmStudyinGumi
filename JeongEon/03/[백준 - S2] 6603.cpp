#include <iostream>
#include <vector>

using namespace std;

int S[13];
int lotto[6];
int k;

void getCombi(int start, int depth) {
	if (depth == 6) {
		for (int i = 0; i < 6; i++) {
			cout << lotto[i] << " ";
		}
		cout << '\n';
		return;
	}
	
	for (int i = start; i < k; i++) {
		lotto[depth] = S[i];
		getCombi(i + 1, depth + 1);
	}
}
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(false);
	cout.tie(false);

	while (1) {
		cin >> k;
		if (k == 0) {
			break;
		}

		for (int i = 0; i < k; i++) {
			cin >> S[i];
		}

		getCombi(0, 0);

		cout << '\n';
	}

	return 0;
}
