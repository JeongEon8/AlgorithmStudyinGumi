#include <iostream>
using namespace std;
 
int box[21][21];
int copybox[21][21];
int d, w, k;
int answer;
 
bool check() {
 
    for (int i = 0; i < w; i++) {
        int maxcount = 0;
        int now = copybox[i][0];
        bool bad = true;
        for (int j = 0; j < d; j++) {
            if (now == copybox[j][i]) {
                maxcount++;
            }
            else {
                maxcount = 1;
                now = copybox[j][i];
            }
            if (maxcount == k) {
                bad = false;
                break;
            }
        }
        if (bad)return false;
    }
 
    return true;
}
int testcont = 0;
void dfs(int count, int line) {
 
    //line(현재 수정할 row)가 d 높이보다 크면 
    if (line >= d) {
        if (check()) {
            if (answer > count) {
                answer = count;
            }
        }
        return;
    }
    //count(현재 수정한 row의 수)가 기존 answer보다 크면, 혹은 k(최소 조건)보다 크면
    if (count >= answer || count > k)return;
    /*
    if (check()) {
        if (answer > count) {
            answer = count;
        }
        return;
    }*/
 
    dfs(count, line + 1);
 
 
 
    for (int i = 0; i < w; i++) {
        copybox[line][i] = 0;
    }
    dfs(count + 1, line + 1);
    for (int i = 0; i < w; i++) {
        copybox[line][i] = box[line][i];
    }
 
 
 
 
 
 
    for (int i = 0; i < w; i++) {
        copybox[line][i] = 1;
    }
    dfs(count + 1, line + 1);
    for (int i = 0; i < w; i++) {
        copybox[line][i] = box[line][i];
    }
 
 
}
 
 
int main() {
    int ctn;
    cin >> ctn;
    for (int ct = 1; ct <= ctn; ct++) {
        cin >> d >> w >> k;
        answer = k;
        int a;
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < w; j++) {
                cin >> a;
                box[i][j] = a;
                copybox[i][j] = a;
            }
        }
        if (k == 1) {
            answer = 0;
        }
        else {
            dfs(0, 0);
        }
 
        cout << '#' << ct << ' ' << answer << '\n';
    }
}
