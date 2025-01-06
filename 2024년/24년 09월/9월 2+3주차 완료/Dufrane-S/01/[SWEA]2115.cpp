#include <iostream>
#include <vector>
#include <algorithm>
 
using namespace std;
int box[11][11];
int done[11][11];
 
int n, m, c;
int answer;
bool check(int y, int x) {
    for (int i = x; i < x + m; i++) {
        if (i == n)return false;
        if (done[y][i] == 1) {
            return false;
        }
    }
    return true;
}
 
void get() {
    vector<int>honey1;
    vector<int>honey2;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (done[i][j] == 1) {
                honey1.push_back(box[i][j]);
            }
            else if (done[i][j] == 2) {
                honey2.push_back(box[i][j]);
            }
        }
    }
     
 
     
 
    sort(honey1.begin(), honey1.end());
    sort(honey2.begin(), honey2.end());
    int sum1 = 0;
    do {
        int tmp = 0;
        int tmpsum = 0;
        for (auto i : honey1) {
            if (tmp + i <= c) {
                tmp += i;
                tmpsum += i * i;
            }
            else {
                if (sum1 < tmpsum)sum1 = tmpsum;
                continue;
            }
        }
        if (sum1 < tmpsum)sum1 = tmpsum;
    } while (next_permutation(honey1.begin(), honey1.end()));
    int sum2 = 0;
    do {
        int tmp = 0;
        int tmpsum = 0;
        for (auto i : honey2) {
            if (tmp + i <= c) {
                tmp += i;
                tmpsum += (i * i);
            }
            else {
                if (sum2 < tmpsum)sum2 = tmpsum;
                continue;
            }
            if (sum2 < tmpsum)sum2 = tmpsum;
        }
    } while (next_permutation(honey2.begin(), honey2.end()));
 
    if (sum1 + sum2 > answer) { answer = sum1 + sum2;  }
}
 
 
void dfs(int count) {
    if (count == 2) {
        get();
        return;
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (done[i][j] == 0) {
                if (check(i, j)) {
                    for (int k = j; k < j + m; k++) {
                        done[i][k] = count+1;
                    }
                    dfs(count + 1);
                    for (int k = j; k < j + m; k++) {
                        done[i][k] = 0;
                    }
                }
            }
        }
    }
}
 
 
int main() {
    int ctn;
    cin >> ctn;
    for (int ct = 1; ct <= ctn; ct++) {
        answer = 0;
        cin >> n >> m >> c;
         
        int a;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> a;
                box[i][j] = a;
            }
        }
        dfs(0);
         
     
        cout << '#'<<ct<<' '<<answer<<'\n';
    }
}
