// 9461. 파도반 수열

#include <iostream>
#include <vector>

using namespace std;

int T;
int N;
vector<long long int> arr = { 1, 1, 1 };

void pado() {
	for (int i = 3; i < N; i++) {
		long long int temp = arr[i - 2] + arr[i - 3];
		arr.push_back(temp);
	}
}

int main(void) {
	cin >> T;

	for (int tc = 1; tc <= T; tc++) {
		arr.clear();
		arr.push_back(1);
		arr.push_back(1);
		arr.push_back(1);
		cin >> N;

		pado();

		cout << arr[N - 1] << '\n';
	}

	return 0;
}
