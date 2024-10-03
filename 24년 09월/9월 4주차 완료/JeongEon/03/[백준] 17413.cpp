#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string input;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	getline(cin, input);
	//cout << input << endl;

	string result = "";
	string temp = "";
	for (int i = 0; i < input.length(); i++) {
		if (input[i] == '<') {
			if (temp != "") {
				reverse(temp.begin(), temp.end());
				result += temp;
				temp = "";
			}
			for (; input[i] != '>'; i++) {
				result += input[i];
			}
			result += input[i];
		}
		else if (input[i] == ' ') {
			reverse(temp.begin(), temp.end());
			result += temp + " ";
			temp = "";
		}
		else {
			temp += input[i];
		}
	}

	if (temp != "") {
		reverse(temp.begin(), temp.end());
		result += temp + " ";
		temp = "";
	}

	cout << result << endl;

	return 0;
}
