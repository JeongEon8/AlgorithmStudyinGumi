#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    
    int size = arr.size();
    for(int i = 0; i < size; i++){
        if(arr[i]%divisor == 0){
            answer.push_back(arr[i]);
        }
    }
    if(answer.empty()){
        answer.push_back(-1);
    }
    else{
        sort(answer.begin(), answer.end());
    }
    
    return answer;
}
