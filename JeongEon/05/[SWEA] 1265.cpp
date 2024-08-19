#include <iostream>
#include <cmath>

using namespace std;

int main(void) {
	int T;
	cin >> T;
	
	for (int tc = 1; tc <= T; tc++) {
		int N, P;
		cin >> N >> P;

		int A = N / P;
		int B = N % P;
		long long int result = pow(A, P);

		for (int i = 0; i < B; i++) {
			result = result / A;
			result = result * (A + 1);
		}
		cout << "#" << tc << " ";
		cout << result << '\n';
	}
	return 0;
}
