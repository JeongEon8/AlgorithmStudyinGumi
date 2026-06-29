#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    
    priority_queue<int, vector<int>, greater<>>pq;
    
    while(!scoville.empty()){
        pq.push(scoville[scoville.size() - 1]);
        scoville.pop_back();
    }
    
    while(pq.size() > 1){
        int first = pq.top();
        if(first >= K){            
            break;
        }
        pq.pop();
        int second = pq.top();
        pq.pop();
        
        int newFood = first + (second * 2);
        pq.push(newFood);
        answer++;
    }
    
    if(pq.size() <= 1 && pq.top() < K){
        answer = -1;
    }
    
    return answer;
}
