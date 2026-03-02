#include <iostream>
#include <queue>
#include <string.h>
using namespace std;

int max_friends = 0;
int N;
char relationship[50][50] = {'N'};
int visit[50] = {0, };

void bfs(int v){
    memset(visit, 0, sizeof(visit));
    queue<pair<int,int>> q;
    q.push({v, 0});
    visit[v] = 1;
    int friends = 0;
    int depth = 0;
    while(!q.empty()){
        int now_v = q.front().first;
        int depth = q.front().second;
        q.pop();
        if(depth > 1) continue;
        for(int i=0; i<N; i++){
            if(relationship[now_v][i] == 'Y' && visit[i] == 0){
                visit[i] = 1;
                friends++;
                q.push({i, depth+1});
            }
        }
    }
    if(friends > max_friends) max_friends = friends;
}

int main(int argc, const char * argv[]) {
    cin >> N;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> relationship[i][j];
        }
    }
    for(int i=0; i<N; i++){
        bfs(i);
    }
    cout << max_friends << endl;
    return 0;
}
