#include <string>
#include <vector>
#include <algorithm>
#include <iostream>


using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    sort(citations.begin(), citations.end());
    
    int size = citations.size();

    for(int h = citations[size - 1]; h >= 0; h--){
        int cnt = 0;
        for(int j = 0; j < size; j++){
            if(citations[j] >= h){
                cnt++;
            }
        }
        if(cnt >= h && size - cnt <= h){
            answer = h;
            break;
        }
    }
    
    return answer;
}
