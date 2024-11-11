#include <iostream>
#include <cstdio>
#include <string>
#include <map>
#include <vector>

using namespace std;

int main(void) {
	int cnt = 1;
	while (1) {
		int n;
		cin >> n;

		if (n == 0) {
			break;
		}

		string name[101];
		cin.ignore();
		for (int i = 1; i <= n; i++) {
			string input;
			getline(cin, input);
			name[i] = input;
		}

		bool arr[101] = { 0 };
		for (int i = 0; i < (2 * n) - 1; i++) {
			int num;
			char flag;
			cin >> num >> flag;
			if (arr[num]) {
				arr[num] = false;
			}
			else {
				arr[num] = true;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (arr[i]) {
				cout << cnt << " " << name[i] << '\n';
			}
		}

		cnt++;
	}

	return 0;
}
