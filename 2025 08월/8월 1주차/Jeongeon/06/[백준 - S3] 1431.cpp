#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

bool cmp(string a, string b) {
	int asize = a.length();
	int bsize = b.length();
	int asum = 0;
	int bsum = 0;

	if (asize != bsize) {
		return asize < bsize;
	}

	for (int i = 0; i < a.size(); i++) {
		if (a[i] >= '0' && a[i] <= '9') {
			asum += int(a[i]) - '0';
		}

		if (b[i] >= '0' && b[i] <= '9') {
			bsum += int(b[i]) - '0';
		}
	}

	if (asum != bsum) {
		return asum < bsum;
	}

	return a < b;
}

int main() {
	int N;
	string serial[50];

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> serial[i];
	}

	sort(serial, serial + N, cmp);
	for (int i = 0; i < N; i++) {
		cout << serial[i] << "\n";
	}

	return 0;
}
