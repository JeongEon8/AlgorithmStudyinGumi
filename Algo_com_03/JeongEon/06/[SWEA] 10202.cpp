#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(void) {
	int T;
	cin >> T;
	
	for (int tc = 1; tc <= T; tc++) {
        int N;
        cin >> N;

        vector<string> word;
        word.resize(3);

        for (int j = 0; j < 3; j++) {
            cin >> word[j];
        }

        int sum = 0;
        for (int k = 0; k < N; k++) {
            if (word[0][k] == word[1][k]) {
                if (word[1][k] != word[2][k])
                    sum++;
            }
            else if (word[0][k] != word[1][k]) {
                if (word[0][k] == word[2][k])
                    sum++;
                else if (word[0][k] != word[2][k]) {
                    if (word[1][k] == word[2][k])
                        sum++;
                    else if (word[1][k] != word[2][k])
                        sum += 2;
                }
            }
        }

		cout << "#" << tc << " ";	
        cout << sum << '\n';
	}
	return 0;
}
