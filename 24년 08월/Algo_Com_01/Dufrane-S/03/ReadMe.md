# [백준 - S1] 5014. 스타트링크
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
bfs


## :round_pushpin: **Logic**
1. 현재 층에 아래로 갈 수 있는 층 & 위로 갈 수 있는 층 queue에 추가 후 방문처리하는 bfs
```#include <iostream>
#include <queue>
using namespace std;
int box[1000001];

int main(void){

    queue<int>q;
    int f,s,g,u,d;
    bool flag=false;
    cin>>f>>s>>g>>u>>d;
    q.push(s);
    box[s]=1;
    if(s==g){
        cout<<0;
        return 0;
    }else {
        while (!q.empty()) {
            int now = q.front();
            if (now == g) {
                flag = true;
                break;
            }
            q.pop();
            if (now + u <= f && !box[now + u]) {
                box[now + u] = box[now] + 1;
                q.push(now + u);
            }
            if (now - d > 0 && !box[now - d]) {
                box[now - d] = box[now] + 1;
                q.push(now - d);
            }
        }
    }
    if(flag){
        cout<<box[g]-1;
    }else{
        cout<<"use the stairs";
    }
}
```
