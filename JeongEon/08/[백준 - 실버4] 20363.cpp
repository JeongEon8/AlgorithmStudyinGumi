#include <iostream>

using namespace std;

int main(void) {
	long long int sun, water;
	cin >> sun >> water;

	long long int result = 0;
	if (sun > water) {
		result = sun + water / 10 + water;
	}
	else {
		result = water + sun / 10 + sun;
	}

	cout << result << endl;

	return 0;
}
