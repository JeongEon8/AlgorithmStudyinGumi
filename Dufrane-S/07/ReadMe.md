# [백준 - S4] 1620. 나는야 포켓몬 마스터 이다솜 
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
map


## :round_pushpin: **Logic**
1. map과 배열을 통해 빠르게 찾을 수 있게 한다.
2. 빠른 입출력 주의
```
 #include <iostream>
#include <unordered_map>
#include <string>
using namespace std;


int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	int n,m;
	cin >> n >> m;
	string box[n];
	unordered_map<string, int>cm;
	string s;
	for (int i = 1; i <= n; i++) {
		cin >> s;
		box[i-1] = s;
		cm[s] = i;
	}
	for (int i = 0; i < m; i++) {
		cin >> s;
		if ('0' <= s[0] && s[0] <= '9') {
			cout << box[stoi(s)-1] <<'\n';
		}
		else {
			cout << cm[s] << '\n';
		}
	}
}

```
