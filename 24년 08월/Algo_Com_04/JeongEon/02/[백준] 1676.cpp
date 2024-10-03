#include <iostream>

using namespace std;

int main(void) {
	int N;
	cin >> N;

	int result = 0;
	for (int i = 5; i <= N; i *= 5) {
		result += N / i;
	}

	cout << result;

	return 0;
}
