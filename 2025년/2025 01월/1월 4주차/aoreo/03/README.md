# [백준 - 실버 4] 9012. 괄호
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
스택

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. '(' 를 1로, ')' 를 -1로 저장하고, 스택에서 하나씩 꺼내기
2. 꺼내는 값을 더하여 VPS 여부 확인, 양수일 경우 '('가 짝꿍없이 뒤에 나온 것이므로 탈출
```java
while(stack.isEmpty() == false) {
                result += stack.pop();
                if(result > 0) {
                    System.out.println("NO");
                    break;
                }
            }
```
3. 빠져나왔을 때, result가 양수인 경우, 스택이 비어있는데 result가 음수인 경우는 모두 짝꿍이 맞지 않는 괄호이므로 "NO"를 출력. result < 0을 해야 '('를 마지막으로 꺼내고 끝난 경우도 고려 가능
```java
if(stack.isEmpty() && result == 0) System.out.println("YES");
            else if(stack.isEmpty() && result < 0) System.out.println("NO");
```   

## :black_nib: **Review**
- 스택 문제 옛날에는 이해도 못는데 성장했다....실버4 풀면서 으쓱하기

## 📡 Link
https://www.acmicpc.net/problem/9012
