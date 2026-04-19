#include <iostream> // cin, cout
#include <vector>	// vector
#include <algorithm>	// sort

using namespace std;

int L, C;
vector<char> v;

bool isThereMoJa(string str) {
	int mo = 0;
	int ja = 0;
	for (int i = 0; i < str.length(); i++) {
		if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') {
			mo++;
		}
		else {
			ja++;
		}
	}

	if (mo >= 1 && ja >= 2) {
		return true;
	}

	return false;
}

void backtracking(string str, int start) {
	if (str.length() == L) {
		if (isThereMoJa(str)) {
			cout << str << '\n';
		}
		return;
	}

	for (int i = start; i < C; i++) {
		str.push_back(v[i]);
		backtracking(str, i + 1);
		str.pop_back();
	}

}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> L >> C;

	char input;
	for (int i = 0; i < C; i++) {
		cin >> input;
		v.push_back(input);
	}

	sort(v.begin(), v.end());

	backtracking("", 0);

	return 0;
}
