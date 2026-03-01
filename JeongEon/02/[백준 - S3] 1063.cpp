#include<iostream>
#include<string>

using namespace std;

#define SIZE 8
 
string king, stone;
int N;

// R, L, B, T, RT, LT, RB, LB
int dx[SIZE] = { 0, 0, 1, -1, -1, -1, 1, 1 };
int dy[SIZE] = { 1, -1, 0, 0, 1, -1, 1, -1 };
 
int main(void) {
    int kx, ky, sx, sy;
    string direction;
    
    cin >> king >> stone;
 
    for (int i = 0; i < 2; i++) {
        if (i == 0) {
            ky = king[i] - 'A';
            sy = stone[i] - 'A';
        }
        else {
            kx = '8' - king[i];
            sx = '8' - stone[i];
        }
    }
 
    cin >> N;
    int dir = 0;
 
    for (int i = 0; i < N; i++) {
        cin >> direction;
 
        if (!direction.compare("R")) {
            dir = 0;
        }
        else if (!direction.compare("L")) {
            dir = 1;
        }
        else if (!direction.compare("B")) {
            dir = 2;
        }
        else if (!direction.compare("T")) {
            dir = 3;
        }
        else if (!direction.compare("RT")) {
            dir = 4;
        }
        else if (!direction.compare("LT")) {
            dir = 5;
        }
        else if (!direction.compare("RB")) {
            dir = 6;
        }
        else if (!direction.compare("LB")) {
            dir = 7;
        }
 
        int kmx = kx + dx[dir];
        int kmy = ky + dy[dir];
 
        if (kmx < 0 || kmx >= SIZE || kmy < 0 || kmy >= SIZE) {
            continue;
        }
        if (kmx == sx && kmy == sy) {
            int smx = sx + dx[dir];
            int smy = sy + dy[dir];
            
            if (smx < 0 || smx >= SIZE || smy < 0 || smy >= SIZE) {
                continue;
            }
            
            sx = smx; sy = smy;
        }
        kx = kmx; ky = kmy;
    }
 
    cout << (char)(ky + 'A') << SIZE - kx << '\n';
    cout << (char)(sy + 'A') << SIZE - sx << '\n';
 
    return 0;
}
