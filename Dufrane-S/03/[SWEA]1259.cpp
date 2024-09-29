#include <iostream>
#include <vector>
#include <deque>
 
using namespace std;
 
vector<pair<int, int>> v;
deque <pair<int, int>> result;
bool done[100001];
bool complete;
int n;
 
void dfs(int depth) {
    if (complete)return;
    if (depth == v.size()) {
        for (auto i: result) {
            cout << i.first << ' ' << i.second << ' ';
        }
        cout << '\n';
        complete = true;
        return;
    }
 
    for (int i = 0; i < n; i++) {
        if (result.empty()) {
            result.push_back(v[i]);
            done[i] = true;
            dfs(depth + 1);
            done[i] = false;
            result.pop_back();
        }else if(!done[i]){
            if(v[i].first==result.back().second){
                done[i]=true;
                result.push_back(v[i]);
                dfs(depth+1);
                done[i]=false;
                result.pop_back();
            }else if(v[i].second==result.front().first){
                done[i]=true;
                result.push_front(v[i]);
                dfs(depth+1);
                done[i]=false;
                result.pop_front();
            }
        }
    }
 
}
 
int main() {
    int ctn;
    cin >> ctn;
    for (int ct = 1; ct <= ctn; ct++) {
        v.clear();
        result.clear();
        complete = false;
        cin >> n;
        int a, b;
        for (int i = 0; i < n; i++) {
            done[i] = false;
            cin >> a >> b;
            v.emplace_back(a, b);
        }
        cout<<'#'<<ct<<' ';
        dfs(0);
    }
}
