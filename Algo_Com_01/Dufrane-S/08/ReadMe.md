# [백준 - S5] 5628. 종이 자르기
 
## ⏰  **time**
20분

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
	int  n, m;
	int k;
	cin >> n >> m;
	cin >> k;
	vector < int > sv;
	vector < int > gv;

	for (int i = 0; i < k; i++) {
		int a, b;
		cin >> a >> b;
		if (a==0) {
			sv.push_back(b);
		}
		else {
			gv.push_back(b);
		}
	}
	gv.push_back(0);
	sv.push_back(0);
	int glarge=0;
	int slarge = 0;
	sv.push_back(m);
	gv.push_back(n);
	sort(gv.begin(), gv.end());
	sort(sv.begin(), sv.end());

	for (int i = 0; i < gv.size()-1; i++) {
		if (glarge < gv[i + 1] - gv[i])glarge = gv[i + 1] - gv[i];
	}
	for (int i = 0; i < sv.size()-1; i++) {
		if (slarge < sv[i + 1] - sv[i])slarge = sv[i + 1] - sv[i];
	}
	cout << glarge * slarge;
}

```
