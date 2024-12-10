#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int nn;
		cin >> nn;
		
		map<string, int> m;
		for (int j = 0; j < nn; j++) {
			string s1; cin >> s1;
			string s2; cin >> s2;
			m[s2]++;
		}
		
		int sum = 1;
		for (auto x : m) {
			sum *= x.second + 1;
		}

		cout << sum - 1 << "\n";
	}
}
