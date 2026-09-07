#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    int ptr = 0;
    answer.push_back(arr[0]);
    for(int i =1; i < arr.size(); i++){
        if(!answer.empty()){
            if(answer[ptr] == arr[i]){
                continue;
            }
            answer.push_back(arr[i]);
            ptr++;
        }
    }

    return answer;
}
