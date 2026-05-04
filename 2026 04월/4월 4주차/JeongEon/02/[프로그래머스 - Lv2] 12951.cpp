#include <string>

using namespace std;

string solution(string s) {
    string answer = "";
    
    for(int i = 0; i < s.length(); i++){
        if((i == 0) || (i > 0 && s[i-1] == ' ')) {
            if(s[i] >= 97 && s[i] <= 122){
                s[i] = s[i] - 32;
            }
        }
        else if(s[i] >= 65 && s[i] <= 90){
            s[i] = s[i] + 32;
        }
           
        answer += s[i];
    }
    
    return answer;
}
