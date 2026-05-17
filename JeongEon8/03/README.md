# [PGS - Lv2] 155641_호텔 대실

## ⏰**time**
1시간 30분

## :pushpin: **Algorithm**
문자열

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 오름차순 정렬
2. 현재 방의 종료 시간과 다음 사용 시작 시간을 비교해서 현재 방의 종료 시간보다 다음 시작 시간이 이르면 방추가
   ```cpp
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
   ```

## :black_nib: **Review**
- 대 상 혁, 이렇게 편리한 걸 만들다니!

## 📡 Link
[프로그래머스 Lv2 호텔 대실](https://school.programmers.co.kr/learn/courses/30/lessons/155651?language=cpp)
