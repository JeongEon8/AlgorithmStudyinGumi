#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;
 
 
int answer;
int a;
 
void change(string s, int idx,  int count) {
    if (count == a) {
        if (answer < stoi(s))answer = stoi(s);
        return;
    }
    if (idx == s.size()) {
        if ((a - count) % 2 == 0) {
            if (answer < stoi(s))answer = stoi(s);
            return;
        }
        else {
            char temp = s[s.size() - 1];
            s[s.size() - 1] = s[s.size() - 2];
            s[s.size() - 2] = temp;
            if (answer < stoi(s))answer = stoi(s);
            return;
        }
    }
    int now = s[idx] - '0';
    int large = now;
    vector<int>largeidx;
    for (int i = idx + 1; i < s.size(); i++) {
        int temp = s[i] - '0';
        if (temp > large) {
            large = temp;
            largeidx.clear();
            largeidx.push_back(i);
        }
        else if (temp == large) {
            largeidx.push_back(i);
        }
    }
    if(large!=now){
        for (auto i : largeidx) {
            string tmp = s;
            char temp = tmp[i];
            tmp[i] = tmp[idx];
            tmp[idx] = temp;
            change(tmp, idx+1 , count + 1);
        }
    }
    else if (large == now && !largeidx.empty()) {
        change(s, idx + 1, count + 1);
        change(s, idx , count + 1);
    }
    else if (large == now) {
        change(s, idx + 1, count);
    }
    else {
        if (idx == s.size() - 1) {
            if ((a - count) % 2 == 0) {
                if (answer < stoi(s))answer = stoi(s);
                return;
            }
            else {
                char temp = s[s.size() - 1];
                s[s.size() - 1] = s[s.size() - 2];
                s[s.size() - 2] = temp;
                if (answer < stoi(s))answer = stoi(s);
                return;
            }
        }
        else {
            change(s, idx + 1, count);
        }
         
    }
}
 
int main() {
    int ct;
    cin >> ct;
    for (int ctnow = 1; ctnow <= ct; ctnow++) {
        answer = 0;
        string s;
        cin >> s;
        cin >> a;
 
        change(s,0,0);
        cout << '#' << ctnow << ' ' << answer << '\n';
    }
}
