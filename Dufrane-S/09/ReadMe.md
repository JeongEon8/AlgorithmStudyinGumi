# [백준 - S3] 2559. 수열
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
구현


## :round_pushpin: **Logic**
1. 
```
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;



int main() {
	int n, m;
	cin >> n >> m;
	vector<int>v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	int answer;
	int sum = 0;
	for (int i = 0; i < m; i++) {
		sum += v[i];
	}
	answer = sum;
	for (int i = m; i < n; i++) {
		sum += v[i];
		sum -= v[i - m];
		answer = max(sum, answer);
	}
	cout << answer;
}

```
