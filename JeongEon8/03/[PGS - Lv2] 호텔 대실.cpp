#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int toInt(string time, int add){
    string temp = time;
    string h = temp.erase(2,3);
    temp = time;
    string m = temp.erase(0,3);
    int hh = stoi(h);
    int mm = stoi(m) + add;
    if(mm >= 60){
        hh++;
        mm -= 60;
    }
    
    int value = hh * 100 + mm;
    
    return value;
}

int toInt(string time){
    time.erase(2,1);
    return stoi(time);
}

int solution(vector<vector<string>> book_time) {
    int answer = 0;
    
    // 1. 오름차순 정렬
    sort(book_time.begin(), book_time.end());
    
    // 2. 현재 방의 종료 시간과 다음 사용 시작 시간을 비교해서 현재 방의 종료 시간보다 다음 시작 시간이 이르면 방추가
    vector<int> rooms;
    int start;
    int end;
    rooms.push_back(toInt(book_time[0][1], 10));
    for(int i = 1; i < book_time.size(); i++){
        start = toInt(book_time[i][0]);
        end = toInt(book_time[i][1], 10);
        
        bool addRoom = true;
        for(int j = 0; j < rooms.size(); j++){
            if(rooms[j] <= start){
                rooms[j] = end;
                addRoom = false;
                break;
            }
        }
        
        if(addRoom){
            rooms.push_back(end);
        }
    }
    
    answer = rooms.size();
    
    return answer;
}
