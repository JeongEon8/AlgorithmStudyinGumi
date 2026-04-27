#include <iostream>
#include <string>

using namespace std;

string input,result;
string a, b;

int main() {
	cin >> input;

	result = "{"; 

	for (int i = 0; i < input.size()-2; i++) {
		for (int j = i+1; j < input.size()-1; j++) {
			
			string val;

			for (int u = i; u >= 0; u--)
				val += input[u];

			for (int u = j; u > i; u--)
				val += input[u];

			for (int u = input.size() - 1; u > j; u--)
				val += input[u];

			if (result > val) result = val;
			
		}
		
	}


	cout << result << endl;
}
