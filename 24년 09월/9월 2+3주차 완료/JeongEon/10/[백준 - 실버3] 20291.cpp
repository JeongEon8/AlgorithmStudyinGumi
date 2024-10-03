#include <iostream>
#include <string>
#include <map>

using namespace std;

int main(void) {
	int N;
	cin >> N;
	
	map<string, int> file;
	for (int i = 0; i < N; i++) {
		string input;
		cin >> input;
		
		string name = "";
		for (int j = 0; j < input.length(); j++) {
			if (input[j] == '.') {
				name = input.substr(j + 1);
				break;
			}
		}

		file.insert({ name, 0 });
		file[name]++;
	}

	for (auto iter = file.begin(); iter != file.end(); iter++) {
		cout << iter->first << " " << iter->second << endl;
	}

	return 0;
}
