#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int num[10] = { 0 };

int main(void) {
	string N;
	cin >> N;

	int maxi = 1;
	for (int i = 0; i < N.length(); i++) {
		if (N[i] - '0' == 9 || N[i] - '0' == 6) {
			if (num[6] < num[9]) {
				num[6]++;
				maxi = max(maxi, num[6]);
			}
			else {
				num[9]++;
				maxi = max(maxi, num[9]);
			}
		}
		else {
			num[N[i] - '0']++;
			maxi = max(maxi, num[N[i] - '0']);
		}
	}

	cout << maxi << endl;

	return 0;
}
