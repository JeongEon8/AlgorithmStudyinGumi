#include <iostream>
#include <vector>
using namespace std;

int main()
{

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    vector<int> vec;

    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        vec.push_back(num);
    }

    int  max = 1;

    for (int i = 0; i < n; i++) {
        int cnt = 1, diff = -1;
        for (int j = i + 1;j < n; j++) {
            if (vec[i] == vec[j]) {
                cnt++;
            }
            else if (diff == -1) {
                diff = vec[j];
            }
            else if (diff != vec[j]) {
                break;
            }
        }
        if (max < cnt) {
            max = cnt;
        }
    }

    cout << max;


}

