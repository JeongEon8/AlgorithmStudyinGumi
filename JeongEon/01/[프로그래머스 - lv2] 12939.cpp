#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

string solution(string s) {
    string answer = "";
    
    istringstream ss (s);
    string str;
    vector<int> vec;
    while(getline(ss, str, ' ')){
        vec.push_back(stoi(str));
    }
    
    sort(vec.begin(), vec.end());
    
    answer += to_string(vec.front()) + " " + to_string(vec.back());
    
    return answer;
}
