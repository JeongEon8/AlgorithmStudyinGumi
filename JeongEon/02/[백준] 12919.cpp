#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

string temp = "";

void addAB(string arr, string result) {
	if (arr == result) {
		cout << "1\n";
		exit(0);
	}

	if (arr.length() >= result.length()) {
		return;
	}

	if (result[result.length() - 1] == 'A') {
		temp = result;
		temp.erase(temp.length() - 1);
		addAB(arr, temp);
	}

	if (result[0] == 'B') {
		temp = result;
		temp.erase(temp.begin());
		reverse(temp.begin(), temp.end());
		addAB(arr, temp);
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string S, T;
	cin >> S;
	cin >> T;
	addAB(S, T);

	cout << 0 << '\n';

	return 0;
}
