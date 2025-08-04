# [백준] 9012. 괄호 


## ⏰ **time**
10분

## :pushpin: **Algorithm**
자료 구조, 문자열, 스택 

## ⏲️**Time Complexity**
O(n)

## :round_pushpin: **Logic**
1. `(`가 들어오면 스택에 1을 삽입한다.
2. `)`가 들어오면 스택을 pop한다.
3. `)`가 더 많아서 스택이 빈 채로 pop을 시도하면, `vps=false`가 되고 NO를 출력한다.
4. 끝까지 돌았는데도 스택이 비지 않았다면, `(`이 더 많은 것이므로 NO
5. 깔끔하게 비었다면 YES~
```java
                if (msg.charAt(j)=='(') {
        stack.push(1);
                } else {
                        if (stack.isEmpty()) {
// 닫는 괄호가 더 많아졌다면
vps = false;
        break;
        }
        stack.pop();
                }
                        }

                        if (!stack.isEmpty()) {
vps = false;
        }
```


## :black_nib: **Review**
날먹은 이번주까지... 

## 📡**Link**
https://www.acmicpc.net/problem/9012
