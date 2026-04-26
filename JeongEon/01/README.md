# [프로그래머스 - Lv2] 12939. 최댓값과 최솟값

## ⏰ **time**
18분

## :pushpin: **Algorithm**
정렬, 문자열

## ⏲️ **Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. string 입력받은 후 " " 띄어쓰기로 쪼개서 Int 형태로 변환 후 vector에 저장한다.
2.sort() 함수를 이용해 정렬한다.
```cpp
while(getline(ss, str, ' ')){
  vec.push_back(stoi(str));
}
```

## :black_nib: **Review**
- string 쪼개서 저장하는 법 신기한거 배웠다! `istringstream` 개꿀.

## 📡 Link
[프로그래머스 레벨2 최댓값과 최솟값](https://school.programmers.co.kr/learn/courses/30/lessons/12939)
