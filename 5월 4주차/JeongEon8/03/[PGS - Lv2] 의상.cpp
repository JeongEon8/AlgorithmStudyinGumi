#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    
    // 1. 의상 종류 별로 몇 개의 의상이 있는지 count
    map<string, int> m;
    for(int i = 0; i < clothes.size(); i++){
        m[clothes[i][1]]++;
    }
    
    // 2. 모든 경우의 수 - 아무 것도 입지 않을 경우
    // 따라서 (각 옷의 개수 + 1)을 모두 곱한 후에 - 1하면 된다.
    for(auto i : m){
        answer *= (i.second + 1);
    }
    
    
    return answer - 1;
}
