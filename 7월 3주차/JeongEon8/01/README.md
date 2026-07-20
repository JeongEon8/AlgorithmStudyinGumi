# [PGS - Lv2] 01_이진 변환 반복하기

## ⏰**time**
30분

## :pushpin: **Algorithm**
이진, String

## ⏲️**Time Complexity**
$O(N!)$

## :round_pushpin: **Logic**
1. s 크기가 1이 아닐 때 계속 반복해서 뒤집음
   ```cpp
    while(s.size() != 1) {
        len = 0;
        for(int i = 0; i < s.size(); ++i) {
            if(s[i] == '0') answer[1]++;
            else len++;
        }
        s = "";
        while(len) {
            s += to_string(len % 2);
            len /= 2;
        }
        reverse(s.begin(), s.end());
        answer[0]++;
    }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 lv2 이진 변환 반복하기](https://school.programmers.co.kr/learn/courses/30/lessons/70129)
