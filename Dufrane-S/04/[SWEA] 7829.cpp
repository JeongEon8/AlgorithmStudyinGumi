#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <climits>
using namespace std;

int main() {

	int tc_n;
	cin >> tc_n;
	for (int tc = 1; tc <= tc_n; tc++) {
		int p;
		cin >> p;
		int large=0;
		int small = INT_MAX;
		for (int i = 0; i < p; i++) {
			int a;
			cin >> a;
			if (large < a)large = a;
			if (small > a)small = a;
		}

		

		int answer = small * large;
		cout << '#' << tc << ' ' << answer<<'\n';
	}

}
