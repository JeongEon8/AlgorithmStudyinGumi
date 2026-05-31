#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    
    for(int i = 0; i < s.length(); i++){
        vector<char> check;
        bool fine = true;
        for(int j = i; j < i + s.size(); j++){
            int ptr = j % s.size();
            if(s[ptr] == '(' || s[ptr] == '{' ||s[ptr] == '['){
                check.push_back(s[ptr]);
            }
            else{
                if(check.empty() ||
                   (s[ptr] == ')' && check.back() != '(') ||
                   (s[ptr] == '}' && check.back() != '{') ||
                   (s[ptr] == ']' && check.back() != '[')){
                    fine = false;
                    break;
                }
                check.pop_back();
            }
        }
        if(fine && check.empty()){
            answer++;
        }
    }
    
    
    return answer;
}
