#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
	long long N, M;
	cin >> N >> M;

	if (N > M) {
		cout << 0;
	}
	else {
		long long result = 1;
		for (long long  i = 1; i <= N; i++) {
			result *= i;
			result %= M;
		}

		cout << result << endl;
	}


	return 0;
}
