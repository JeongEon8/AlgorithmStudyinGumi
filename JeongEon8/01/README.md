# [PGS - Lv2] 01_튜플

## ⏰**time**
1시간

## :pushpin: **Algorithm**
맵

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 숫자로 변환해서 쌍을 만듬ㄹ어서 확인
   ```cpp
    for(int i = 2; i < s.size() - 2; i++){
        if('0' <= s[i] && s[i] <= '9'){
            m[stoi(s.substr(i))]++;
            while('0' <= s[i] && s[i] <= '9'){
                i++;
            }
        }
    }
    
    vector<pair<int, int>> mtov(m.begin(), m.end());
    sort(mtov.begin(), mtov.end(), compare);
   ```

## :black_nib: **Review**
- 
 
## 📡 Link
[프로그래머스 Lv2 튜플](https://school.programmers.co.kr/learn/courses/30/lessons/64065)
