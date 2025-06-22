#include <iostream>

using namespace std;

int arr[100001], d[100001];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	int answer = -100001;
	for (int i = 0; i < n; ++i) {
		d[i] = max(arr[i], d[i - 1] + arr[i]);
		answer = max(answer, d[i]);
	}

	cout << answer;

	return 0;
}
