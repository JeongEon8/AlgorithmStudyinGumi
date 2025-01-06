#include <iostream>
#include <string>
using namespace std;

int main(int argc, char* argv[])
{
	bool m;	// 모음 1번 입력됬는지
	bool check;	// 이전 결과가 모음, 자음
	bool flag;	// 결과
	bool con; // 이번 결과가 모음인지, 자음인지
	int count;	// 3연속
	string s;
	char pre;
	char v[5] = { 'a', 'e', 'i', 'o', 'u' };

	while (1) {
		m = false;
		flag = false;
		check = false;
		count = 0;

		cin >> s;

		if (s == "end") {
			break;
		}

		for (int i = 0; i < s.length(); ++i) {
			con = false;
			if (i != 0) {	// 3번 조건
				if (s[i] == s[i - 1] && s[i] != 'e' && s[i] != 'o') {
					flag = true;
					break;
				}
			}

			for (int j = 0; j < 5; ++j) {
				if (s[i] == v[j]) {
					if (check == false) {
						count = 0;
					}
					m = true;
					check = true;
					con = true;
					++count;
				}
			}

			if (!con) {
				if (check == true) {
					count = 0;
				}
				check = false;
				++count;
			}

			if (count == 3) {	// 2번 조건
				flag = true;
				break;
			}

			if (flag) {
				break;
			}
		}
		if (!m) {	// 1번 조건
			flag = true;
		}

		if (flag) {
			cout << "<" << s << "> is not acceptable." << endl;
		}
		else {
			cout << "<" << s << "> is acceptable." << endl;
		}
	}

	return 0;
}
