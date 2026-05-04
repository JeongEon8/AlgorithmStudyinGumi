#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 1;
    
    sort(routes.begin(), routes.end());
    int temp = routes[0][1];
    
    for(auto route : routes){
        if(temp < route[0]){
            answer++;
            temp = route[1];
        }
        
        if(temp >= route[1]){
            temp = route[1];
        }
    }
    
    return answer;
}
