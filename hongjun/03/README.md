# [백준 - S2] 1406. 에디터
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
스택

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 커서 왼쪽에 있는 건 스택으로 처리
- 오른쪽은 deque로 처리
```python
# 왼쪽 스택에 문자가 존재해야 실행
if com[0] == 'L' and stack_L:           
        deq_R.appendleft(stack_L.pop())

# 오른쪽 덱에 문자가 존재해야 실행    
elif com[0] == 'D' and deq_R:           
    stack_L.append(deq_R.popleft())

# 왼쪽 스택에 문자가 존재해야 실행
elif com[0] == 'B' and stack_L:         
    stack_L.pop()

# 그냥 왼쪽 스택에 입력 문자 추가
elif com[0] == 'P':
    stack_L.append(com[1])              
```

## :black_nib: **Review**


## 📡**Link**
- https://www.acmicpc.net/problem/1406
