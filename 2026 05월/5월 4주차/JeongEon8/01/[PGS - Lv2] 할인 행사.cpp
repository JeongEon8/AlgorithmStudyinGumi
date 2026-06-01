#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    
    // 1. 맵에 {물품이름, 개수}로 10개 미리 넣는다.
    map<string, int> m;
    for(int i = 0; i < 10; i++){
        m[discount[i]]++;
    }
    
    // 2. 사려고 했던 물품의 개수가 맞는지 확인한다.
    for(int i = 0; i < discount.size() - 9; i++){
        bool signUp = true;
        
        for(int j = 0; j < want.size(); j++){
            if(m[want[j]] != number[j]){
                signUp = false;
                break;
            }
        }
        
        if(signUp){
            answer++;
        }
        
        m[discount[i]]--;
        if(i < discount.size() - 10){
            m[discount[i+10]]++;
        }
    }
    
    return answer;
}
