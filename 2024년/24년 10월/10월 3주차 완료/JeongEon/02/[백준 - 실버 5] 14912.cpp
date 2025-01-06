#include <iostream>
#include <string>

using namespace std;

int main(void) {
	int n;
	cin >> n;
	int d;
	cin >> d;

	int cnt = 0;
	for (int i = 1; i <= n; i++) {
		string temp = to_string(i);
		for (char j : temp) {
			if (j - '0' == d) {
				cnt++;
			}
		}
	}

	cout << cnt << '\n';

	return 0;
}
