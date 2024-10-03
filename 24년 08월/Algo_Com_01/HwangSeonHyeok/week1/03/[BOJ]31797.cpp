#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, m;
    vector<pair<int, int>> vec;

    cin >> n >> m;

    for (int i = 1; i <= m; i++) {
        int num1, num2;
        cin >> num1 >> num2;
        vec.push_back(make_pair(num1, i));
        vec.push_back(make_pair(num2, i));
    }

    sort(vec.begin(), vec.end());


    cout << vec[(n - 1) % (m * 2)].second;



}

