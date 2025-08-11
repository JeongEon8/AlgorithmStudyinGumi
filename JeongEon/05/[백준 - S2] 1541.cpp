#include <iostream>
#include <string>
using namespace std;

string input;
int result = 0;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> input;

    string num;
    bool minus = false;

    for (int i = 0; i <= input.size(); i++) {
        if (input[i] == '-' || input[i] == '+' || i == input.size()) {
            if (minus) {
                result -= stoi(num);
                num = "";
            }
            else {
                result += stoi(num);
                num = "";
            }
        }
        else {
            num += input[i];
        }

        if (input[i] == '-') {
            minus = true;
        }
    }

    cout << result;
}
