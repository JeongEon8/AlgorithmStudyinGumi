# [PGS - Lv2] 01_방문 길이

## ⏰**time**
30분

## :pushpin: **Algorithm**
방문탐색

## ⏲️**Time Complexity**
$O(N!)$

## :round_pushpin: **Logic**
1. 자표 이동 후 가본 적 있는 곳인지 검사
   ```cpp
        if(m.find(make_pair(make_pair(x,y),make_pair(nx,ny)))==m.end() && 
           m.find(make_pair(make_pair(nx,ny),make_pair(x,y)))==m.end()) {
            m.insert({make_pair(make_pair(x,y),make_pair(nx,ny)), true}); 
            answer++;
        }
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://school.programmers.co.kr/learn/courses/30/lessons/49994
