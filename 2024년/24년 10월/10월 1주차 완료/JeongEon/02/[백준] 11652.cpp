#include <iostream>
#include <map>

using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long N;
	cin >> N;

	map<long long, long long> m;
	for (long long i = 0; i < N; i++) {
		long long input;
		cin >> input;		
		m[input]++;
	}
	
	long long maxi = 0;
	long long result;
	for (auto x : m) {
		if (x.second > maxi) {
			maxi = x.second;
			result = x.first;
		}
	}

	cout << result;

	return 0;
}
