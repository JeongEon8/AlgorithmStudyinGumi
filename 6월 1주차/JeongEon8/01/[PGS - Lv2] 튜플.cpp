#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

bool compare(pair<int, int>& a, pair<int, int>& b){
    return a.second > b.second;
}

vector<int> solution(string s) {
    unordered_map<int, int> m;
    vector<int> answer;
    
    for(int i = 2; i < s.size() - 2; i++){
        if('0' <= s[i] && s[i] <= '9'){
            m[stoi(s.substr(i))]++;
            while('0' <= s[i] && s[i] <= '9'){
                i++;
            }
        }
    }
    
    vector<pair<int, int>> mtov(m.begin(), m.end());
    sort(mtov.begin(), mtov.end(), compare);
    for(int i = 0; i < mtov.size(); i++){
        answer.push_back(mtov[i].first);
    }
    return answer;
}
