#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;



int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    vector<vector<long long>> vec;
    vector<long long> ans;
    int n, m;
    long long dist = 0;
    cin >> n >> m;
    
    for (int i = 0; i < m; i++) {
        vector<long long> coordinateVec;
        for (int j = 0; j < n; j++) {
            long long num;
            cin >> num;
            coordinateVec.push_back(num);
        }
        vec.push_back(coordinateVec);

    }

    vector<vector<long long>> rotatedVec;
    for (int i = 0; i < n; i++) {
        vector<long long> axisVec;
        for (int j = 0; j < m; j++) {
            axisVec.push_back(vec[j][i]);
        }
        sort(axisVec.begin(), axisVec.end());
        rotatedVec.push_back(axisVec);
    }
    
    
    for (int i = 0; i < n; i++) {
        long long mid;
        if (m % 2 == 0) {
            mid = (rotatedVec[i][m / 2] + rotatedVec[i][m / 2 - 1])/2;
        }
        else {
            mid = rotatedVec[i][m / 2];
        }

        for (int j = 0; j < m; j++) {
            dist += llabs(rotatedVec[i][j] - mid);
        }
        ans.push_back(mid);
    }
    
    cout << dist << '\n';
    
    for (int i = 0; i < n; i++) {
        cout << ans[i] << ' ';
    }
    


}