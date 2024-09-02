# [SWEA - D3] 1240. 단순 2진 암호코드

## ⏰  **time**
120분

## :pushpin: **Algorithm**
구현


## :round_pushpin: **Logic**
1. 코드의 뒷부분이 항상 1로 시작하니까 뒤에서부터 찾아 나가서 분리한다.
2. 뒤에서부터 하면 짝수자리수와 홀수자리수가 바뀌는 것에 주의...
```#include <iostream>
#include <string>
using namespace std;
int main()
{
	int ct;
	cin >> ct;
	for (int ctnow = 1; ctnow <= ct; ctnow++) {
		int n, m;
		cin >> n >> m;
		string s;
		bool check = false;
		int sum = 0;
		int count = 0;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			cin >> s;
			if (check)continue;
			for (int j = m - 1; j >= 0; j--) {
				if (s[j] == '1') {
					check = true;
					count++;
					j--;
					string temp="";
					for (int k = 0; k < 6; k++) {
						temp += s[j];
						j--;
					}j++;
					

					if (temp == "011000") {
						if (count % 2 == 0) {
							sum += (3 * 0);
							answer += 0;
						}
						else {
							sum += 0;
							answer += 0;
						}
						answer += 0;

					}
					else if (temp=="001100") {
						if (count % 2 == 0) {
							sum += (3 * 1);
							answer += 1;
						}
						else {
							sum += 1;
							answer += 1;
						}

					}
					else if (temp=="100100") {
						if (count % 2 == 0) {
							sum += (3 * 2);
							answer += 2;
						}
						else {
							sum += 2;
							answer += 2;
						}

					}
					else if (temp=="011110") {
						if (count % 2 == 0) {
							sum += (3 * 3);
							answer += 3;
						}
						else {
							sum += 3;
							answer += 3;
						}

					}
					else if (temp=="100010") {
						if (count % 2 == 0) {
							sum += (3 * 4);
							answer += 4;
						}
						else {
							sum += 4;
							answer += 4;
						}

					}
					else if (temp=="000110") {
						if (count % 2 == 0) {
							sum += (3 * 5);
							answer += 5;
						}
						else {
							sum += 5;
							answer += 5;
						}

					}
					else if (temp == "111010") {
						if (count % 2 == 0) {
							sum += (3 * 6);
							answer += 6;
						}
						else {
							sum += 6;
							answer += 6;
						}

					}
					else if (temp == "101110") {
						if (count % 2 == 0) {
							sum += (3 * 7);
							answer += 7;
						}
						else {
							sum += 7;
							answer += 7;
						}

					}
					else if (temp == "110110") {
						if (count % 2 == 0) {
							sum += (3 * 8);
							answer += 8;
						}
						else {
							sum += 8;
							answer += 8;
						}

					}
					else if (temp == "101000") {
						if (count % 2 == 0) {
							sum += (3 * 9);
							answer += 9;
						}
						else {
							sum += 9;
							answer += 9;
						}

					}

				}
			}
		}
		if (sum % 10 == 0) {
			cout << '#' << ctnow << ' ' << answer <<'\n';
		}
		else {
			cout << '#' << ctnow << ' ' << 0 << '\n';
		}
	}
}
```
