#include <iostream>		// cin, cout

using namespace std;

string S;

bool function(int L, int R) {
	while (L < R) {
		if (S[L] != S[R]) return 0;
		L++, R--;
	}
	return 1;
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> S;
	int len = S.length();
	for (int i = 0; i < len; i++) {
		if (function(i, len - 1)) {
			cout << len + i;
			return 0;
		}
	}

	return 0;
}
