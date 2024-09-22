#include <iostream>
#include <queue>

using namespace std;

int main(void) {
	int N;
	cin >> N;

	int dasom;
	cin >> dasom;
	priority_queue<int> q;
	for (int i = 1; i < N; i++) {
		int num;
		cin >> num;
		q.push(num);
	}

	int result = 0;
	while (!q.empty()) {
		int num = q.top();
		q.pop();
		if (dasom <= num) {
			num--;
			dasom++;
			q.push(num);
			result++;
		}
	}

	cout << result << endl;


	return 0;
}
