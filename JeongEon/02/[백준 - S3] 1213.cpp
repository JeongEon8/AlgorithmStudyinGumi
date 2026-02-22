#include <iostream>		// cin, cout
#include <cstring>		// memset
#include <queue>		// queue
#include <stack>		// stack

using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	string input;
	cin >> input;

	int alphabet[26];	// ABCDEFGHIJKLMNOPQRSTUVWXYZ
	memset(alphabet, 0, sizeof(alphabet));

	for (int i = 0; i < input.length(); i++) {
		alphabet[input[i] - 65]++;
	}
	
	queue<char> front;
	stack<char> back;

	int i = 0;
	while (i < 26) {
		if (alphabet[i] <= 1) {
			i++;
		}
		else if (alphabet[i] > 1) {
			front.push('A' + i);
			back.push('A' + i);
			alphabet[i] -= 2;
			i = 0;
			continue;
		}
	}

	for (int i = 0; i < 26; i++) {
		if (alphabet[i] != 0) {
			front.push('A' + i);
			alphabet[i]--;
		}
	}

	string result;
	if ((input.length() % 2 == 0 && front.size() == back.size()) || (input.length() % 2 != 0 && front.size() - back.size() == 1)) {
		result = "";
		while (!front.empty()) {
			result.push_back(front.front());
			front.pop();
		}
		while (!back.empty()) {
			result.push_back(back.top());
			back.pop();
		}
	}
	else {
		result = "I'm Sorry Hansoo";
	}

	cout << result << '\n';

	return 0;
}
