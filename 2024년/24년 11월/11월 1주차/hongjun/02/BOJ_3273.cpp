#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

void FASTIO() {
	cin.tie(0);
	cout.tie(0);
	ios_base::sync_with_stdio(false);
}

int nums[100001];

int main()
{
	FASTIO();

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> nums[i];

	}

	int x;
	cin >> x;

	sort(nums, nums + n);

	int st = 0;
	int en = n - 1;

	int answer = 0;
	while (st < en) {
		if (nums[st] + nums[en] == x) {
			answer++;
			st++;
			en--;
		}
		else if (nums[st] + nums[en] < x) {
			st++;
		}
		else en--;

	}

	cout << answer;


	return 0;
}