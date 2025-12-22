#include <iostream>
#include <queue>
using namespace std;
 
char board[22][22];
int n, m, coin1_x, coin1_y, coin2_x, coin2_y;
string s;
int visited[22][22][22][22] = {0, };
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};
bool check = false;
int final = 0;
 
struct Coins { int x1, y1, x2, y2, cnt; };
 
bool isOut(int x, int y)
{
    if((0 <= x && x < n) && (0 <= y && y < m)){
        return true;
    }
    return false;
}
 
int bfs()
{
 
    queue<Coins> q; 
    q.push({ coin1_x, coin1_y, coin2_x, coin2_y, 0 }); 
 
    while(!q.empty()){
        Coins cur = q.front();
        visited[cur.x1][cur.y1][cur.x2][cur.y2] = 1;
        q.pop();
 
        // 방문 값이 10을 넘으면 끝
        if(cur.cnt>10){
            break;
        }
 
        for(int i=0; i<4; i++){
            int nx1 = cur.x1 + dx[i]; 
            int ny1 = cur.y1 + dy[i]; 
            int nx2 = cur.x2 + dx[i]; 
            int ny2 = cur.y2 + dy[i];
 
            // 둘 중 하나만 나간다.
            if((isOut(nx1, ny1) && !isOut(nx2, ny2)) || (!isOut(nx1, ny1) && isOut(nx2, ny2))){
                if(cur.cnt+1>10){
                    return -1;
                }
                return cur.cnt+1;
            }
            
            if(!isOut(nx1, ny1) && !isOut(nx2, ny2)){ // 둘 다 나가면
                continue;
            }
 
            if(board[nx1][ny1]=='#' && board[nx2][ny2]=='#'){
                continue;
            }
 
            // 둘 중 하나만 벽이면, 안 움직이는 건 원상복귀
            if(board[nx1][ny1]=='#'){
                nx1 = cur.x1;
                ny1 = cur.y1;
            }else if(board[nx2][ny2]=='#'){
                nx2 = cur.x2;
                ny2 = cur.y2;
            }
 
            if(!visited[nx1][ny1][nx2][ny2]){
                q.push({ nx1, ny1, nx2, ny2, cur.cnt+1});
                visited[nx1][ny1][nx2][ny2] = true;
            }
        }
    }
    return -1;
}
 
int main()
{
    cin>>n>>m;
    int num = 0;
    for(int i=0; i<n; i++){
        cin>>s;
        for(int j=0; j<s.size(); j++){
            board[i][j] = s[j];
            if(board[i][j]=='o'){ // 동전
                board[i][j] = '.';
                if(num==0){
                    coin1_x = i;
                    coin1_y = j;
                    num++;
                }
                if(num==1){
                    coin2_x = i;
                    coin2_y = j;
                }
            }
        }
    }
 
    cout<<bfs()<<"\n";
    return 0;
}
