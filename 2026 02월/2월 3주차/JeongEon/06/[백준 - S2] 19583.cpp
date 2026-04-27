#include <iostream>		// cin, cout
#include <unordered_map> // unordered_map

using namespace std;

string S, E, Q, timeInput, nickname;
int result;
unordered_map<string, int> nicknames;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> S >> E >> Q;
	while (cin >> timeInput >> nickname) {
		if (timeInput <= S) {
			nicknames[nickname] = 1;
		}
		else if (timeInput >= E && timeInput <= Q) {
			if (nicknames[nickname] == 1) {
				nicknames[nickname] = 2;
				result++;
			}
		}
	}

	cout << result;

	return 0;
}
