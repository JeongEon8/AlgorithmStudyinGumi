#include <iostream>
#include <queue>

using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int T;
	cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		int k; 
		cin >> k;

		priority_queue<long long, vector<long long>, greater<long long>> pq;
		for (int i = 0; i < k; i++) {
			int file;
			cin >> file;
			pq.push(file);
		}

		long long ans = 0;

		while (pq.size() > 1) {
			long long sum = pq.top();
			pq.pop();
			sum += pq.top();
			pq.pop();
			ans += sum;
			pq.push(sum);
		}

		cout << ans << '\n';
	}




	return 0;
}
