#include <iostream>
#include <string>

using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    string input;
    cin >> input;

    int cnt = 0;
    string result = "";
    for (int i = 0; i < input.length(); i++) {
        if (input[i] == 'X') {
            cnt++;
        }
        else {
            if (cnt != 0) {
                if (cnt % 2 == 0) {
                    for (int j = 0; j < cnt / 4; j++) {
                        result += "AAAA";
                    }
                    cnt = cnt % 4;
                    if (cnt % 2 == 0) {
                        for (int j = 0; j < cnt / 2; j++) {
                            result += "BB";
                        }
                    }                
                    cnt = 0;
                }
                else {
                    cout << "-1" << endl;
                    return 0;
                }
            }
            result += input[i];
        }
    }

    if (cnt != 0) {
        if (cnt % 2 == 0) {
            for (int j = 0; j < cnt / 4; j++) {
                result += "AAAA";
            }
            cnt = cnt % 4;
            if (cnt % 2 == 0) {
                for (int j = 0; j < cnt / 2; j++) {
                    result += "BB";
                }
            }
            cnt = 0;
        }
        else {
            cout << "-1" << endl;
            return 0;
        }
    }

    cout << result;

    return 0;
}
