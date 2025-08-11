#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N;
int result = 0;
vector<int> arr;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> N;

    int input;
    for (int i = 0; i < N; i++) {
        cin >> input;
        arr.push_back(input);
    }
    int total;
    cin >> total;

    sort(arr.begin(), arr.end());

    int left = 0;
    int right = N - 1;

    while (left < right) {
        if (arr[left] + arr[right] == total) {
            result++;
            left += 1;
            right -= 1;
        }
        else if (arr[left] + arr[right] > total) {
            right -= 1;
        }
        else {
            left += 1;
        }
    }

    cout << result;

    return 0;
}
