#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    
    map<int, int> m;
    for(int i = 0; i < tangerine.size(); i++) {
        m[tangerine[i]]++;
    }
    
    vector<int> v;
    for(auto u : m) {
        v.push_back(u.second);
    }
    
    sort(v.begin(), v.end(), greater<>());
    
    int cnt = 0;
    for(int i = 0; i < v.size(); i++){
        if(cnt >= k) {
            break;
        }
        
        answer++;
        cnt += v[i];
    }
    
    return answer;
}
