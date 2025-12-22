#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;


int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int a, b, c;
	cin >> a >> b >> c;

	int res = b * b - 4 * a * c;

	if (b % a != 0 || c % a != 0 || res <= 0) {
		cout << "둘다틀렸근";
		return 0;
	}

	for (int i = 2; i <= 256; i *= 2) {
		for (int j = 2; j <= 256; j *= 2) {
			if (i == j) continue;
			if (a * i * i + b * i + c == 0 && a * j * j + b * j + c == 0) {
				cout << "이수근";
				return 0;
			}
		}
	}

	for (int i = -200; i <= 200; i++) {
		for (int j = -200; j <= 200; j++) {
			if (i == j) continue;
			if (a * i * i + b * i + c == 0 && a * j * j + b * j + c == 0) {
				cout << "정수근";
				return 0;
			}
		}
	}

	cout << "둘다틀렸근";

	return 0;
}
