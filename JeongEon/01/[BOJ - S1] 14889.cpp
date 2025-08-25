#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

bool team[20] = {};
int score[20][20] = {};
int N, mymin = 99999999;

void teamset(int idx, int cnt) {
    vector<int> start;
    vector<int> link;
    int start_score = 0;
    int link_score = 0;
    if(cnt == (N/2)) {
        for(int i = 0; i < N; i++) {
            if(team[i] == true) {
                start.push_back(i);
            }
            else {
                link.push_back(i);
            }
        }
        for(int i = 0; i < (N/2); i++){
            for(int j = 0; j < (N/2); j++) {
                start_score += score[start[i]][start[j]];
                link_score += score[link[i]][link[j]];
            }
        }
        
        if(abs(start_score - link_score) < mymin){
            mymin = abs(start_score - link_score);
        }
 
        return;
    }
    
    for(int i = idx; i < N; i++) {
        if(team[i]){
            continue;
        }  
        else {
            team[i] = true;
            teamset(i,cnt+1);
            team[i] = false;
        }
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    cin >> N;
    
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++) {
            cin >> score[i][j];
        }
    }
    
    teamset(0,0);
    cout << mymin << '\n';
    
    return 0;
}
