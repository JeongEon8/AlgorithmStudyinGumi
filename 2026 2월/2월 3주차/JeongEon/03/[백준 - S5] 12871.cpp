#include <iostream>		// cin, cout

using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	string str1;
	cin >> str1;

	string str2;
	cin >> str2;

	int len1 = str1.length();
	int len2 = str2.length();

	string make1 = "";
	for (int i = 0; i < len2; i++) {
		make1 += str1;
	}

	string make2 = "";
	for (int i = 0; i < len1; i++) {
		make2 += str2;
	}

	int result = (make1 == make2 ? 1 : 0);
	cout << result;

	return 0;
}
