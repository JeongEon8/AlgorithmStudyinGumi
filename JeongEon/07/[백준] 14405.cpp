#include <iostream>
#include <string>

using namespace std;

int main(void) {
	string input;
	cin >> input;

	bool yes = true;
	for (int i = 0; i < input.length(); i++) {
		if (i < input.length() - 1 && input.substr(i, 2) == "pi" || input.substr(i, 2) == "ka") {
			i += 1;
		}
		else if ((i <( input.length() - 2)) && (input.substr(i, 3) == "chu")){
			i += 2;
		}
		else {
			yes = false;
			break;
		}
	}

	if (yes == true) {
		cout << "YES" << endl;
	}
	else {
		cout << "NO" << endl;
	}

	return 0;
}
