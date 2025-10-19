#include <iostream>

using namespace std;

int euclidean(int a, int b) {
	int r = a % b;
	if (r == 0) return b;
	return euclidean(b, r);
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	int radius[101];

	cin >> n;
	for (int i = 0; i < n; i++) cin >> radius[i];
	
	for (int i = 1; i < n; i++) {
		int e = euclidean(radius[0], radius[i]);
		cout << radius[0] / e << "/" << radius[i] / e << "\n";
	}

	return 0;
}
