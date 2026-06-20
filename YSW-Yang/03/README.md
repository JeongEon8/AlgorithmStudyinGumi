# [PGS - Lv2] 03_큰 수 만들기

## ⏰**time**

- 50분

## :pushpin: **Algorithm**

- Stack

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 큰 숫자를 앞쪽으로 이동시키는 것이 더 큰 수를 만들 수 있기 때문에 현재까지 저장된 숫자 중에서 현재 숫자보다 작은 숫자가 앞에 있다면 제거한다.
stack은 현재까지 선택한 숫자를 저장하며, stack.peek()이 현재 숫자보다 작고 제거할 수 있는 횟수(k)가 남아 있다면 해당 숫자를 제거한다.
   ```java
        for(int i = 0; i < number.length(); i++){
            if(stack.isEmpty()){
                stack.push(number.charAt(i));
            }else{
                while(!stack.isEmpty() && stack.peek() < number.charAt(i) && k > 0){
                    stack.pop();
                    k--;
                }
                stack.push(number.charAt(i));
            }
        }
   ```

2. 앞선 과정이 끝난 후에도 k가 남아 있다면, 이미 내림차순 형태로 정렬되어 있어 가장 뒤쪽 숫자부터 제거한다.
이후 stack에 저장된 숫자를 순서대로 꺼내 결과 문자열을 만든다.
   ```java
        while(k-- > 0){
            stack.pop();
        }
        
        for(int i = 0; i < stack.size(); i++){
            sb.append(stack.get(i));
        }
        answer = sb.toString();
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42883
