# [PGS - Lv2] 02_택배상자

## ⏰**time**

20분

## :pushpin: **Algorithm**

- Stack

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 컨테이너 벨트에서 1번부터 순서대로 상자를 꺼내 보조 컨테이너(스택)에 넣는다.
상자를 넣을 때마다 스택의 맨 위 상자가 현재 트럭에 실어야 하는 상자(order[index])와 같다면 계속 꺼내어 트럭에 적재한다.
   ```
        int index = 0;
        for(int i = 1; i <= size; i++){
            stack.push(i);
            while(!stack.isEmpty() && stack.peek() == order[index]){
                answer++;
                index++;
                stack.pop();
            }
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/131704
