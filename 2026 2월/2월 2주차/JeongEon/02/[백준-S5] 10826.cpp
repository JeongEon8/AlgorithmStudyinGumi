#include <iostream>		// cin, cout
#include <string>		// string, length(), to_string()
#include <algorithm>	// reverse()

using namespace std;

int n;
string DP[10001];

string sum(string nm2, string nm1) {
	int num = 0;
	int tmp = 0;
	string result = "";
	
	reverse(nm2.begin(), nm2.end());
	reverse(nm1.begin(), nm1.end());

	while (nm2.length() < nm1.length()) {
		nm2 += "0";
	}

	while (nm2.length() > nm1.length()) {
		nm1 += "0";
	}

	for (int i = 0; i < nm2.length(); i++) {
		num = ((nm2[i] - '0') + (nm1[i] - '0') + tmp) % 10;
		result += to_string(num);
		tmp = ((nm2[i] - '0') + (nm1[i] - '0') + tmp) / 10;
	}

	if (tmp != 0) {
		result += to_string(tmp);
	}

	reverse(result.begin(), result.end());
	return result;
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	
	DP[0] = "0";
	DP[1] = "1";

	for (int i = 2; i <= n; i++) {
		DP[i] = sum(DP[i - 2], DP[i - 1]);
	}

	cout << DP[n] << '\n';

	return 0;
}
