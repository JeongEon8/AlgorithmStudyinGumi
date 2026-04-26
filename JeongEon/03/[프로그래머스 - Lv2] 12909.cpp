#include <string>
#include <stack>

using namespace std;

bool solution(string s) {
    bool answer = true;

    stack<int> stac;
    
    for(int i = 0; i < s.length(); i++){
        if(s[i] == '('){
            stac.push(i);
        }
        else if(s[i] == ')'){
            if(stac.empty()){
                answer = false;
                break;
            }
            else {
                stac.pop();
            }
        }
    }
    
    if(!stac.empty()){
        answer = false;
    }
    
    return answer;
}
