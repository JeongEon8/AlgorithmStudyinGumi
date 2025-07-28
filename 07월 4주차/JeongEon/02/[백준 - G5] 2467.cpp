#include <iostream>
#include <algorithm>
#include <cstdlib>

using namespace std;

long long N;
long long input[1000001];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> N;
    for (long long i = 0; i < N; i++) {
        cin >> input[i];
    }

    sort(input, input + N);
    
    int left = 0;
    int right = N - 1;
    int compareSum = abs(input[left] + input[right]);
    int answerA = input[left];
    int answerB = input[right];

    while (left < right) {
        int sum = input[left] + input[right];
        if (abs(sum) <= compareSum) {
            compareSum = abs(sum);
            answerA = input[left];
            answerB = input[right];
        }

        if (sum > 0) {
            right--;
        }
        else {
            left++;
        }
    }

    cout << answerA << ' ' << answerB;


    return 0;
}
