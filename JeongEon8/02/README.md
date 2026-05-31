# [PGS - Lv2] 76502_괄호 회전하기

## ⏰**time**
10분

## :pushpin: **Algorithm**
문자열

## ⏲️**Time Complexity**
$O(N*N)$ 

## :round_pushpin: **Logic**
1. 결국 왼쪽으로 회전하는 것은 원형 수열과 비슷하다.
2. 여는 괄호이면 check에 저장
3. 닫는 괄호일 때 check의 맨 뒤가 동일한 괄호의 여는 괄호면 false
   ```cpp
    for(int i = 0; i < s.length(); i++){
        vector<char> check;
        bool fine = true;
        for(int j = i; j < i + s.size(); j++){
            int ptr = j % s.size();
            if(s[ptr] == '(' || s[ptr] == '{' ||s[ptr] == '['){
                check.push_back(s[ptr]);
            }
            else{
                if(check.empty() ||
                   (s[ptr] == ')' && check.back() != '(') ||
                   (s[ptr] == '}' && check.back() != '{') ||
                   (s[ptr] == ']' && check.back() != '[')){
                    fine = false;
                    break;
                }
                check.pop_back();
            }
        }
        if(fine && check.empty()){
            answer++;
        }
    }
   ```

## :black_nib: **Review**

- 요즘은 TWS에 빠졌어요. 나보다 어린 친구들 좋아해도 되는 건지 참 이상한 감정이 느껴져요..

## 📡 Link
[프로그래머스 Lv2 괄호 회전하기](https://school.programmers.co.kr/learn/courses/30/lessons/76502)
