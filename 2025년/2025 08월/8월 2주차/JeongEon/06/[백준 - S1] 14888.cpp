#include <iostream>

using namespace std;

int N;
int arr[11];
int operators[4]; // 연산자
int mmin = 1000000001;
int mmax = -1000000001;

void getanswer(int result, int idx) {
    if (idx == N) {
        if (result > mmax) {
            mmax = result;
        }

        if (result < mmin) {
            mmin = result;
        }

        return;
    }

    for (int i = 0; i < 4; i++) {
        if (operators[i] > 0) {
            operators[i]--; 
            if (i == 0) {
                getanswer(result + arr[idx], idx + 1);
            }
            else if (i == 1) {
                getanswer(result - arr[idx], idx + 1);
            }
            else if (i == 2) {
                getanswer(result * arr[idx], idx + 1);
            }
            else {
                getanswer(result / arr[idx], idx + 1);
            }
            operators[i]++;
        }
    }
    return;
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    for (int i = 0; i < 4; i++) {
        cin >> operators[i];
    }

    getanswer(arr[0], 1);

    cout << mmax << '\n';
    cout << mmin;
}
