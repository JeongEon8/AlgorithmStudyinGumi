#include <iostream>
#include <string>
#include <map>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	cin >> N >> M;

	map<string, string> url;
	for (int i = 0; i < N; i++) {
		string URL;
		string pw;
		cin >> URL >> pw;
		url[URL] = pw;
	}

	for (int i = 0; i < M; i++) {
		string input;
		cin >> input;

		cout << url[input] << '\n';
	}

	return 0;
}
