#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(0); 
	cin.tie(0); 
	cout.tie(0); 

    int n;
    cin >> n;
	
    vector <int> dp(n + 1, 0);
	int result = 0;
	int cur = 0; 
	for (int i = 0; i < n; i++) {
		int day, cost;
		cin >> day >> cost;
		cur = max(cur, dp[i]);
		if (i + day <= n) {		
			dp[i + day] = max(dp[i + day], cur + cost);
			result = max(dp[i + day], result);
		}
	}
	cout << result;
}
