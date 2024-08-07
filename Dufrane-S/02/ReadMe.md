# [백준 - S1] 14888. 연산자 끼워넣기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
완전탐색


## :round_pushpin: **Logic**
1. next_permutaion을 활용하여 가능한 모든 경우의 수를 체크
```#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>
using namespace std;


int main() {
	
	int small = INT_MAX;
	int large = INT_MIN;
	vector<int>v;
	vector<int>c;
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	int plus, minus, mult, div;
	cin >> plus >> minus >> mult >> div;
	for (int i = 0; i < plus; i++) {
		c.push_back(1);
	}
	for (int i = 0; i < minus; i++) {
		c.push_back(2);
	}
	for (int i = 0; i < mult; i++) {
		c.push_back(3);
	}
	for (int i = 0; i < div; i++) {
		c.push_back(4);
	}
	sort(c.begin(),c.end());

	do {
		int num = v[0];
		for (int i = 0; i < c.size(); i++) {
			if (c[i] == 1) {
				num += v[i + 1];
			}
			else if (c[i] == 2) {
				num -= v[i + 1];
			}
			else if (c[i] == 3) {
				num *= v[i + 1];
			}
			else if (c[i] == 4) {
				if (v[i + 1] == 0)continue;
				num /= v[i + 1];
			}
			
		}
		large = max(large, num);
		small = min(small, num);
	} while (next_permutation(c.begin(), c.end()));
	
	cout << large << '\n' << small;
}
```
