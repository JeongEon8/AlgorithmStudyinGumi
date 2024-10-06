#include <iostream>
#include <string>
#include <queue>
 
using namespace std;
 
 
int box[100001];
int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};
 
int main() {
    for (int ct = 1; ct <= 10; ct++) {
        int n;
        string s;
        cin >> n;
        int box[100][100];
        int sy;
        int sx;
        for (int i = 0; i < 100; i++) {
            cin >> s;
            for (int j = 0; j < 100; j++) {
                box[i][j] = s[j] - '0';
                if (s[j] == '2') {
                    sy = i;
                    sx = j;
                }
            }
        }
        queue<pair<int, int>> q;
        q.push({sy, sx});
        bool flag=false;
        while (!q.empty()) {
            int nowy = q.front().first;
            int nowx = q.front().second;
            q.pop();
            for (int k = 0; k < 4; k++) {
                int ny = nowy + dy[k];
                int nx = nowx + dx[k];
                if (ny <= 0 || nx < 0 || ny == 100 || nx == 100 || box[ny][nx] == 1)continue;
                if (box[ny][nx] == 3) {
                    flag=true;
                    break;
                }
                box[ny][nx]=1;
                q.push({ny,nx});
            }
        }
        if(flag){
            cout<<'#'<<ct<<' '<<1<<'\n';
        }else{
            cout<<'#'<<ct<<' '<<0<<'\n';
        }
    }
}
