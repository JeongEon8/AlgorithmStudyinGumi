#include <iostream>
#include <string>

using namespace std;



int g1[200] = { 0, };
int g2[200] = { 0, };


int main()
{

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    string n, m;
    int ans = 1e9;
    cin >> n >> m;
    for (int i = 0; i < n.length(); i++) {
        g1[i] = n[i] - '0';
    }
    for (int i = 0; i < m.length(); i++) {
        g2[i] = m[i] - '0';
    }
    for (int i = 0; i <= n.length(); i++) {
        bool possible = true;
        for (int j = 0; j < m.length(); j++) {
            if (g1[i + j] == 2 && g2[j] == 2) {
                possible = false;
                break;
            }
        }
        if (possible) {
            int curLength;
            if (n.length() > i + m.length()) {
                curLength = n.length();
            }
            else {
                curLength = i + m.length();
            }
            if (ans > curLength) {
                ans = curLength;
            }
        }
    }
    for (int i = 0; i <= m.length(); i++) {
        bool possible = true;
        for (int j = 0; j < n.length(); j++) {
            if (g2[i + j] == 2 && g1[j] == 2) {
                possible = false;
                break;
            }
        }
        if (possible) {
            int curLength;
            if (m.length() > i + n.length()) {
                curLength = m.length();
            }
            else {
                curLength = i + n.length();
            }
            if (ans > curLength) {
                ans = curLength;
            }
        }
    }
    cout << ans;


}