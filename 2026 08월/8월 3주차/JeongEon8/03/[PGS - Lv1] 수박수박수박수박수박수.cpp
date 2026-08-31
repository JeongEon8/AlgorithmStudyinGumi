#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    
    vector<string> watermelon;
    watermelon.push_back("수");
    watermelon.push_back("박");
    
    for(int i = 0; i < n; i++){
        if(i%2 == 0){
            answer += watermelon[0];
        }
        else if(i%2 == 1){
            answer += watermelon[1];
        }
    }
    
    
    return answer;
}
