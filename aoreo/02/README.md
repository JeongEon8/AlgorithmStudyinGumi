# [백준 - S4] 4949.균형잡힌 세상

## ⏰  **time**
40분

## :pushpin: **Algorithm**
스택

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 초기 answer값은 "yes"로 초기화
2. "."이 될 때까지 반복
3. 줄의 한 char씩 읽으며, '.'일 경우 종료, '(', '['은 stack에 삽입, ']', ')'은 stack의 top 값 확인하여 짝이 아닌 경우 "no"로 변경하고 탈출, stack에 값이 없는데 닫는 괄호가 나올 경우에도 동일
```java
                if (c == '.') {
                    break; 
                }else if (c == '(' || c == '[') {
                    stack.push(c); 
                }else if (c == ']' && stack.size() > 0) {
                    if (stack.pop() != '[') {
                        answer = "no";
                        stack.clear();
                        break;
                    }
                } else if (c == ')' && stack.size() > 0) {
                    if (stack.pop() != '(') {
                        answer = "no";
                        stack.clear();
                        break;
                    }
                } else if ((c == ']' || c == ')') && stack.size() == 0) {
                    answer = "no";
                    stack.clear();
                    break;
                }
```
4. '.'이 나와서 탈출했는데도 stack에 값이 남아있을 경우에도 "no"

## :black_nib: **Review**
- 오랜만에 스택 문제 풀려니까 헷갈려서 오래 걸렸네...
- 이렇게 입력받는 방식은 낯설다잉
## 📡 Link
https://www.acmicpc.net/problem/4949
