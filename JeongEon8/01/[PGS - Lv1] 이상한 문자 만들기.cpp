#include <string>
#include <vector>

using namespace std;

string trans(string word)
{
    string result = "";
    for(int j = 0; j < word.length(); j++)
    {
        if(j == 0 || j % 2 == 0){
            if(word[j] >= 65 && word[j] <= 90)
            {
                result += word[j];
            }
            else{
                result += word[j] - 32;    
            }
        }
        else{
            if(word[j] >= 65 && word[j] <= 90)
            {
                result += word[j] + 32;
            }
            else{
                result += word[j];    
            }
        }
    }
    return result;
}

string solution(string s) {
    string answer = "";
    
    
    int size = s.length();
    string word = "";
    for(int i=0; i < size; i++){
        if(s[i] == ' '){
            answer += trans(word);
            word = "";
            answer += " ";
        }
        else{
            word += s[i];
        }
    }
    
    answer += trans(word);
    
    return answer;
}
