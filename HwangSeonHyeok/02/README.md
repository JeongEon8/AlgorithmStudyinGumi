# [PGS - LV2] 131704. 택배상자

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 스택
- 시뮬레이션

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
스택을 보조 컨테이너로 이용하여 맞는 상자가 나올때까지 스택에 넣고 스택의 가장 앞 상자가 지금 넣을 수 있는 상자인지 확인한다.
```java
Stack<Integer> stack = new Stack<>();
int idx = 0;
for(int i = 1; i<=order.length; i++){
    stack.push(i);
    while(!stack.isEmpty() && stack.peek() == order[idx]){
        stack.pop();
        idx++;
        answer++;
    }
}
```
## :black_nib: **Review**

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/131704