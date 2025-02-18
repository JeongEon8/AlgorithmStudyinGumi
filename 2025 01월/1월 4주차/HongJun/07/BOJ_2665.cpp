#include <iostream>
#include <cstdio>
#include <queue>
#include <vector>

using namespace std;
char map[50][50];
int cost[50][50];
int X[4] = {1, -1, 0, 0};
int Y[4] = {0, 0, 1, -1};
priority_queue<pair<int, pair<int, int>>> pq; //변경수, x, y

int main(void){
ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

    int n;
    int x, y, cnt;
    int next_x, next_y, next_cnt;
    cin >> n;
    for(int i=0; i<n; i++){
        scanf("%s",map[i]);
    }
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cost[i][j]= -1;
        }
    }

    pq.push(make_pair(0, make_pair(0, 0)));
    cost[0][0] = 0;
    while(!pq.empty()){
        cnt = -pq.top().first;
        x = pq.top().second.first;
        y = pq.top().second.second;
        pq.pop();

        if(cost[x][y] < cnt)
            continue;

        for(int i=0; i<4; i++){
            next_x = x + X[i];
            next_y = y+ Y[i];
            if(next_x < 0 || next_x >= n|| next_y < 0 || next_y >=n){
                continue;
            }
            if(map[next_x][next_y] == '0'){ //검
                next_cnt = cnt+1;
            }
            else{   //흰
                next_cnt = cnt;
            }

            if(cost[next_x][next_y] ==-1){
                cost[next_x][next_y] = next_cnt;
                pq.push(make_pair(-next_cnt, make_pair(next_x, next_y)));
            }
            else if(cost[next_x][next_y] > next_cnt){
                cost[next_x][next_y] = next_cnt;
                pq.push(make_pair(-next_cnt, make_pair(next_x, next_y)));
            }
        }
    }
    printf("%d\n", cost[n-1][n-1]);

}