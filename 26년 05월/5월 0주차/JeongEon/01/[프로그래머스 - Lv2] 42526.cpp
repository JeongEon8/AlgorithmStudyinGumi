#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    vector<int> days;
    
    for(int i = 0; i < progresses.size(); i++){
        int last_progresses = 100 - progresses[i];
        int day;
        if(last_progresses % speeds[i] == 0){
            day = last_progresses / speeds[i];
        }
        else{
            day = last_progresses / speeds[i] + 1;    
        }
        days.push_back(day);
    }
    
    int cnt = 1;
    int flag = days[0];
    for(int i = 1; i < days.size(); i++){
        if(flag < days[i]){
            flag = days[i];
            answer.push_back(cnt);
            cnt = 1;
            continue;
        }
        cnt++;
    }
    
    answer.push_back(cnt);
    
    return answer;
}
