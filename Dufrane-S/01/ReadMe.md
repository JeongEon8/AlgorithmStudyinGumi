# [백준 - B2] 1978. 소수 찾기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
수학


## :round_pushpin: **Logic**
1. 소수 미리 1000까지 배열에 저장해주기
2. 배열로 소수 판단하기
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
