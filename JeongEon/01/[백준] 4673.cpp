#include <iostream>
#include <cstring>
#include <string>

using namespace std;

int main(void) {
	int arr[10000];
	memset(arr, 0, sizeof(arr));

	for (int num = 1; num < 10000; num++) {
		string temp = to_string(num);
		int ptr = num;
		for (int i = 0; i < temp.length(); i++) {
			ptr += temp[i] - '0';
		}
		if (ptr > 10000) {
			continue;
		}
		arr[ptr]++;
	}

	for (int i = 1; i < 10000; i++) {
		if (arr[i] == 0) {
			cout << i << "\n";
		}
	}

	return 0;
}
