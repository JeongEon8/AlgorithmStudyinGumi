#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int T, x1, y1, x2, y2, cx, cy, r, n;
	float distance = 0;
	cin >> T;

	while (T--) {
		int cnt = 0;
		cin >> x1 >> y1 >> x2 >> y2;
		cin >> n;

		while (n--) {
			cin >> cx >> cy >> r;

			distance = sqrt(pow(cx - x1, 2) + pow(cy - y1, 2));

			bool start_in_circle = sqrt(pow(cx - x1, 2) + pow(cy - y1, 2)) <= r;
			bool end_in_circle = sqrt(pow(cx - x2, 2) + pow(cy - y2, 2)) <= r;

			if (start_in_circle != end_in_circle)
				cnt++;
		}

		cout << cnt << "\n";
	}
    
    return 0;
}
