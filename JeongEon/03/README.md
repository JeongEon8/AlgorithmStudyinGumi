# [프로그래머스 - Lv2] 12909. 올바른 괄호

## ⏰ **time**
8분

## :pushpin: **Algorithm**
스택

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. '(' 여는 괄호라면 스택에 넣어!
2. ')' 닫는 괄호라면 스택이 비었는지 확인하고, 비었다면 False, 안 비었다면 pop해서 계속 string을 확인해!
```cpp
    for(int i = 0; i < s.length(); i++){
        if(s[i] == '('){
            stac.push(i);
        }
        else if(s[i] == ')'){
            if(stac.empty()){
                answer = false;
                break;
            }
            else {
                stac.pop();
            }
        }
    }
```

## :black_nib: **Review**
- 이거 뭔가 백준에서 봤던 문제 같은데? 야호

## 📡 Link
[프로그래머스 레벨2 올바른 괄호](https://school.programmers.co.kr/learn/courses/30/lessons/12909)
