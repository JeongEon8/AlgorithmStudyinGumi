# [PGS - Lv2] 01_괄호 회전하기

## ⏰**time**

- 20분

## :pushpin: **Algorithm**

- 큐, 스택

## ⏲️**Time Complexity**

$O(n^2)$

## :round_pushpin: **Logic**

1. 순서를 바꿔주기 위해 큐에 담아준다.
   - 큐 대신 StringBuilder를 사용해도 될듯
2. 순서를 바꾸면 스택을 이용해서 괄호가 맞는지 확인
   ```
   static boolean check(Queue<Character> que) {
           Deque<Character> stack = new ArrayDeque<>();
   
           for (char c : que) {           
               if (c == '(' || c == '{' || c == '[') {
                   stack.push(c);
               } else {
                   if (stack.isEmpty()) return false;
                   char open = stack.pop();
                   if (c == ')' && open != '(') return false;
                   if (c == '}' && open != '{') return false;
                   if (c == ']' && open != '[') return false;
               }
           }
           return stack.isEmpty();
       }
   ```

## :black_nib: **Review**



## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/76502
