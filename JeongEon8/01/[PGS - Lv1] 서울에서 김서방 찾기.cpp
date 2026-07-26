#include <string>
#include <vector>
#include <string>

using namespace std;

string solution(vector<string> seoul) {
    string answer = "김서방은 ";
    
    int cnt = seoul.size();
    for(int i = 0; i < cnt; i++){
        if(seoul[i] == "Kim"){
            answer += to_string(i);
            break;
        }
    }
    
    answer += "에 있다";
    
    return answer;
}
