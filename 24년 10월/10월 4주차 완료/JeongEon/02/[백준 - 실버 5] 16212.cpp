#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
	int N;
	cin >> N;

	vector<int> vec;
	for (int i = 0; i < N; i++) {
		int input;
		cin >> input;
		vec.push_back(input);
	}

	sort(vec.begin(), vec.end());

	for (int i = 0; i < vec.size(); i++) {
		cout << vec[i] << " ";
	}

	return 0;
}
