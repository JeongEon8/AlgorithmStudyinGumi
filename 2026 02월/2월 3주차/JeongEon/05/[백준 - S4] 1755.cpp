#include <iostream>		// cin, cout
#include <vector>		// vector
#include <algorithm>	// sort()

using namespace std;


int N, M;
string s;
string nums[11] = { "zero" ,"one" ,"two" ,"three" ,"four" ,"five" ,"six" ,"seven" ,"eight" ,"nine" };
vector<pair<string, int>> result;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> M >> N;

	for (int i = M; i <= N; i++) {
		if (i >= 10) {
			s = nums[i / 10] + " " + nums[i % 10];
			result.push_back({ s,i });
		}
		else {
			s = nums[i % 10];
			result.push_back({ s,i });
		}
	}

	sort(result.begin(), result.end());

	for (int i = 0; i < result.size(); i++) {
		cout << result[i].second << " ";
		if (i % 10 == 9) cout << '\n';
	}

	return 0;
}
