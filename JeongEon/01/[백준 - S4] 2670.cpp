#include <iostream>			// cin, cout
#include <cmath>			// max

using namespace std;

int N;
double num[10001];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> num[i];
	}

	double result = 0;

	for (int i = 1; i <= N; i++) {
		num[i] = max(num[i], num[i] * num[i - 1]);
		result = max(result, num[i]);
	}

	cout << fixed, cout.precision(3);
	cout << result;


	return 0;
}

