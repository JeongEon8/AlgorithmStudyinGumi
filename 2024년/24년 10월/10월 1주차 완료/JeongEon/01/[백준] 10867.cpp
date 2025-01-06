#include <iostream>
#include <map>

using namespace std;

int main(void) {
	int N;
	cin >> N;

	map<int, int> m;
	for (int i = 0; i < N; i++) {
		int input;
		cin >> input;
		m.insert({ input, 1 });
	}

	for (auto x : m) {
		cout << x.first << " ";
	}

	return 0;
}
