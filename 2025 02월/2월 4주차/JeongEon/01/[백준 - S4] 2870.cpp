#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
string str;
vector<string> nums;

bool cmp(const string& x, const string& y) {
    if (x.size() == y.size()) {
        return x <= y;
    }
    else {
        return x.size() <= y.size();
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> N;

    while (N--) {
        cin >> str;
        string num;
        for (char c : str) {
            if (c >= '0' && c <= '9') {
                if (num.size() == 1 && num.front() == '0') {
                    num = c;
                }
                else {
                    num += c;
                }
            }
            else if (!num.empty()) {
                nums.push_back(num);
                num.clear();
            }
        }

        if (!num.empty()) {
            nums.push_back(num);
        }
    }

    sort(nums.begin(), nums.end(), cmp);

    for (string& num : nums) {
        cout << num << "\n";
    }
    return 0;
}
