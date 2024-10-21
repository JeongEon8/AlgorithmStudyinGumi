#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
	int N;
	cin >> N;

	vector<double> vec;
	for (int i = 0; i < N; i++) {
		double input;
		cin >> input;
		vec.push_back(input);
	}

	sort(vec.begin(), vec.end());

	cout << fixed;
	cout.precision(3);
	for (int i = 0; i < 7; i++) {
		cout << (double)vec[i] << '\n';
	}

	return 0;
}
