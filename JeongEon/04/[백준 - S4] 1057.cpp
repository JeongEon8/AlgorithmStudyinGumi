#include <iostream>
#include <cmath>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, kim, im;
	int round = 1;

	cin >> N >> kim >> im;

	while (max(kim, im) % 2 || abs(kim - im) > 1) {
		if (kim % 2) {
			kim = kim / 2 + 1;
		}
		else {
			kim /= 2;
		}

		if (im % 2) {
			im = im / 2 + 1;
		}
		else {
			im /= 2;
		}

		round++;
	}

	cout << round;

	return 0;
}
