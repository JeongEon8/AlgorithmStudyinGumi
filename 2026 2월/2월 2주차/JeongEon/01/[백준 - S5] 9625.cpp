#include <iostream>

using namespace std;

int K, A, B;

void function(int k, int a0, int b0, int a1, int b1) {
	if (k == K) {
		cout << A << " " << B << '\n';
		return;
	}
	
	A = a0 + a1;
	B = b0 + b1;
	function(k + 1, a1, b1, A, B);
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	A = 0;
	B = 1;
	cin >> K;
	
	function(1, 1, 0, A, B);

	return 0;
}
