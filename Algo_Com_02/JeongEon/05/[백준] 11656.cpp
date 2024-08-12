// 백준
// 실버 5
// 11656. 접미사 배열

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
	string input;
	cin >> input;
	int size = input.length();
	vector<string> result;
	reverse(input.begin(), input.end());
	for (int i = 0; i < size; i++) {
		result.push_back(input);
		input.pop_back();
		reverse(result[i].begin(), result[i].end());
	}

	sort(result.begin(), result.end());

	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << endl;
	}


	return 0;
}
