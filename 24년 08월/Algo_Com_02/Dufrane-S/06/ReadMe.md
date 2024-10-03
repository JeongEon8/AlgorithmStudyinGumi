# [백준 - S4] 1244. 스위치 켜고 끄기
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
구현


## :round_pushpin: **Logic**
1. 남여 구분 후 각각 구현
```#include <iostream>

using namespace std;


int main() {

	int n;
	cin >> n;
	int box[n];
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		box[i] = a;
	}
	int s;
	cin >> s;
	for (int i = 0; i < s; i++) {
		int a,b;
		cin >> a >> b;
		if (a == 1) {
			int c = 1;
			while (b * c <= n) {
				box[b*c-1] = !box[b*c-1];
				c++;
			}
		}
		else {
			int start = b;
			int end = b;
			box[start - 1] = !box[start - 1];
			start--; end++;
			while (end-1<n&&start-1>=0&&box[start - 1]== box[end - 1]) {
				box[start - 1] = !box[start - 1];
				box[end - 1] = !box[end - 1];
				start--; end++;
			}
		}

	}
	for (int i = 1; i <= n; i++) {
		cout << box[i-1] << ' ';
		if (i % 20== 0 )cout << '\n';
	}
}

```
