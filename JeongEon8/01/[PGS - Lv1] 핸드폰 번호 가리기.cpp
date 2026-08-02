#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    string answer = "";
    int size = phone_number.length();
    int star_size = size - 4;
    for(int i= 0; i < phone_number.length(); i++){
        if(i < star_size){
            answer += "*";
        }
        else{
            answer += phone_number[i];
        }
    }
    return answer;
}
