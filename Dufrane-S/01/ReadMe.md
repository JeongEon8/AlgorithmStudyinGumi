# [백준 - S2] 1654. 랜선 자르기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
이분탐색


## :round_pushpin: **Logic**
1. 이분탐색으로 자른 랜선 수가 m이 되는 경우 탐색
2. 그 중에 가장 큰 수를 다시 2분 탐색
```#include <iostream>
#include <vector>

using namespace std;

int box[1001];
int main(void) {
	int n;
	cin >> n;
	vector<int>v;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	
	for (int i = 2; i <= 100; i++) {
		if (box[i] == 0) {
			int j = 2;
			while (i*j <= 1000) {
				box[i*j] = 1;
				j++;
			}
		}
	}
	int answer = 0;
	for (auto i : v) {
		if (box[i] == 0 && i!=1)answer++;
	}
	cout << answer;
}
```
