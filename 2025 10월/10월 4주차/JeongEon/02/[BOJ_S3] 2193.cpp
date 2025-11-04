#include <iostream>

using namespace std;

int main() {
	int N;
	long long pinary_num[91];
	
	cin >> N;

	pinary_num[0] = 0;
	pinary_num[1] = 1;
	pinary_num[2] = 1;
	for (int i = 3; i <= N; i++) {
		pinary_num[i] = pinary_num[i - 1] + pinary_num[i - 2];
	}

	cout << pinary_num[N];

	return 0;
}
