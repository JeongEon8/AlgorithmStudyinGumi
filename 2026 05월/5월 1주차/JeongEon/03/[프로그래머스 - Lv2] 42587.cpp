#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    
    priority_queue<int> pq;
    queue<pair<int, int>> q;
    
    int len = priorities.size();
    for(int i = 0; i < len; i++){
        q.push({i, priorities[i]});
        pq.push(priorities[i]);
    }
    
    int cnt = 1;
    while(true){
        pair<int, int> tmp = q.front();
        q.pop();
        
        if(tmp.second != pq.top()){
            q.push(tmp);
        }
        else{
            if(tmp.first == location){
                answer = cnt;
                break;
            }
            else{
                cnt++;
                pq.pop();
            }
        }
    }
    return answer;
}
