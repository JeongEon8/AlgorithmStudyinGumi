#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, K;
	cin >> N >> K;
	
	int input;
	vector<int> arr;
	for (int i = 0; i < N; i++) {
		cin >> input;
		arr.push_back(input);
	}

	sort(arr.begin(), arr.end());

	cout << arr[K - 1];

	return 0;
}
