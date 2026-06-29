#include <vector>
#include <queue>
using namespace std;

// 방향벡터: 위 오 아래 왼(시계방향)
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

int visited[100][100];

int solution(vector<vector<int> > maps) {
    int answer = 0;
    queue<pair<int, int>> q;
    int n = maps.size(); // 행
    int m = maps[0].size(); // 열
    
    q.push({0, 0});
    visited[0][0] = 1;
    
    while(!q.empty()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        
        for(int i = 0; i < 4; i++){
            int ny = y+ dy[i];
            int nx = x + dx[i];
            
            if(0 <= ny && ny < n && 0 <= nx && nx < m){
                if(maps[ny][nx] == 1&& visited[ny][nx] == 0){
                    q.push(make_pair(ny,nx));
                    visited[ny][nx]= visited[y][x] + 1;
                    if(ny == n - 1 && nx == m - 1)
                        return visited[ny][nx];
                }
            }
        }
    }
    
    return -1;
}
