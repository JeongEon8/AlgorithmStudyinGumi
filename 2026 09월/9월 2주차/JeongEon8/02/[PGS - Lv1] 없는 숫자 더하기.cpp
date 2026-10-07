#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

int solution(vector<int> numbers) {
    int answer = 0;
    int size = numbers.size();
    
    map<int, int> zerotonine;
    for(int i = 0; i <= 9; i++){
        zerotonine.insert({i, i});
    }
    
    for(int i = 0; i < size; i++){
        zerotonine.erase(numbers[i]);
    }
    
    for(auto iter : zerotonine){
        answer += iter.first;
    }
    
    return answer;
}
