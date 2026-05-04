#include <string>
#include <vector>
#include <iostream>
#include <set>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    answer.push_back(0);
    answer.push_back(0);
    
    int cnt[10] = { 0 };

    set<string> s;
    set<string>::iterator iter;
    
    s.insert(words[0]);
    cnt[0] = 1;
    int turn = 1;
    for(int i = 1; i < words.size(); i++){
        cnt[turn]++;
        
        // 중복
        iter = s.find(words[i]);
        if(iter != s.end()){
            answer[0] = turn + 1;
            answer[1] = cnt[turn];
            break;
        }
        
        // 끝말잇기 규칙 위반
        int last_length = words[i-1].length();
        if(words[i - 1][last_length - 1] != words[i][0]) {
            answer[0] = turn + 1;
            answer[1] = cnt[turn];
            break;
        }
        
        // 한글자 단어 위반
        if(words[i].length() <= 1){
            answer[0] = turn + 1;
            answer[1] = cnt[turn];
            break;
        }
        
        s.insert(words[i]);
        turn++;
        if(turn >= n){
            turn = 0;
        }
    }

    return answer;
}
