#include <iostream>
#include <set>
#include <map>
#include <string>

using namespace std;

// 전역변수
int N;
char game;
map<char, int> num;

int main(void) {
	num.insert({ 'Y', 1 });
	num.insert({ 'F', 2 });
	num.insert({ 'O', 3 });

	cin >> N >> game;

	string input;
	set<string> player;
	for (int i = 0; i < N; i++) {
		cin >> input;
		player.insert(input);
	}

	cout << player.size()/num[game] << endl;
	return 0;
}
