#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    int ptr = 0;
    int ptr2 = people.size() - 1;
    
    sort(people.begin(), people.end());
    
    while(ptr <= ptr2){
        if(people[ptr] + people[ptr2] <= limit){
            ptr++;
        }
        
        ptr2--;
        answer++;
    }

    return answer;
}
