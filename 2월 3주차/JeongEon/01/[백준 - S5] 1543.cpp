#include <iostream>		// cin, cout
#include <string>

using namespace std;

string input;
string searchKeyword;
int cnt;

bool check(int i) {
	for (int j = 0; j < searchKeyword.length(); j++) {
		if (searchKeyword[j] != input[i + j]) {
			return false;
		}
	}
	return true;
}

void search() {
	for (int i = 0; i < input.length(); i++) {
		if (input[i] == searchKeyword[0]) {
			if (check(i)) {
				cnt++;
				i += searchKeyword.length() - 1;
			}
		}
	}
}	

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	getline(cin, input);
	getline(cin, searchKeyword);
	
	cnt = 0;
	search();

	cout << cnt << '\n';

	return 0;
}
